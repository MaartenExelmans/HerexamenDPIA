package domotica.command;

import domotica.model.*;

public class DoorsOpenCommand implements Command {

    DomoticaObject object;

    public DoorsOpenCommand(DomoticaObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        try {
            object.setDoorsOpened();
        }
        catch (ElectricityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void undo() {
        try {
            object.setDoorsClosed();
        }
        catch (ElectricityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //setAllDoorsOpened = setDoorsOpened
        //setAllDoorsClosed = setDoorsClosed
    }
}
