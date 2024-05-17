package dom.com.lutencu_octavian_siemens_internship.cron;

import dom.com.lutencu_octavian_siemens_internship.enteties.RoomEntity;
import dom.com.lutencu_octavian_siemens_internship.repositories.RoomRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import java.util.List;
import java.util.function.Function;

@Configuration
@EnableScheduling
public class ScheduledAutomaticCheckOutConfiguration implements SchedulingConfigurer {

    private final RoomRepository roomRepository;

    @Value("${scheduled-automatic-checkout-configuration.cron-exp}")
    private String cronExp;

    @Value("${cron-jobs}")
    private boolean CRON_JOBS_ENABLED;

    @Autowired
    public ScheduledAutomaticCheckOutConfiguration(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void configureTasks(@NotNull ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(1);
        threadPoolTaskScheduler.setThreadNamePrefix("scheduler-thread");
        threadPoolTaskScheduler.initialize();
        run(threadPoolTaskScheduler);
    }


    private void run(TaskScheduler scheduler) {
        scheduler.schedule(() -> {
            if (CRON_JOBS_ENABLED) {
                List<RoomEntity>  listOfBookedRooms = roomRepository.getAllBookedRooms().orElseThrow();
                List<RoomEntity> freeRooms = listOfBookedRooms.parallelStream()
                        .map(setRoomAvailableTrue)
                        .toList();
                roomRepository.saveAll(freeRooms);
            }
        }, triggerContext ->
                new CronTrigger(cronExp).nextExecutionTime(triggerContext).toInstant()
        );
    }

    private Function<RoomEntity, RoomEntity> setRoomAvailableTrue = room->{room.setAvailable(true);
                                                                    return room;
    };
}
