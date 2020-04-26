package devices.ac;

import Home.*;
import Home.AC.AirConditionerPurifier;
import Home.AC.PollutionLevel;
import com.zeroc.Ice.Current;
import server.Server;

import java.util.Random;

public class AirConditionerPurifierImpl extends AirConditionerImpl implements AirConditionerPurifier {

    private PollutionLevel pollutionTreshLevel = PollutionLevel.MEDIUM;

    @Override
    public void setPollutionTreshLevel(PollutionLevel pollutionLevel, Current current) {
        Server.logger.info("Set pollution threshold level");

        pollutionTreshLevel = pollutionLevel;
    }

    @Override
    public PollutionLevel getPollutionTreshLevel(Current current) {
        Server.logger.info("Get pollution threshold level");

        return pollutionTreshLevel;
    }

    @Override
    public boolean isPurifyingOn(Current current) throws SwitchedOffError {
        Server.logger.info("Check if air purifying is on");

        if (super.powerState == PowerState.OFF) {
            throw new SwitchedOffError("AC is switched off");
        }

        Random rand = new Random();
        return rand.nextInt(2) != 0;
    }
}
