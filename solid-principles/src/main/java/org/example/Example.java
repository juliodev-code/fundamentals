public class SmartHub {
    private final Activatable device;
    private final Logger logger;

    public SmartHub(Activatable device, Logger logger) {
        this.device = device;
        this.logger = logger;
    }

    public void activate() {
        device.turnOn();
        logger.log("Device was activated");
    }
}