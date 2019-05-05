package control;

import model.Battles.Battle;
import model.ErrorType;
import view.Command;
import view.Request;
import view.View;

public class GraveYard {

    public static boolean finished = false;
    private static View view = View.getInstance();

    public void main(Battle battle) {
        view.showGraveYardMenu();
        while (!finished) {
            Request request = new Request();
            request.getNewCommand();
            request.setBattle(battle);
            Command command = request.getMatchedCommand(8);

            if (command != null && !request.getCommand().equals("help") && !request.getCommand().equals("exit")) {
                command.apply(request);
                view.printError(request.getError());
            } else if (command != null && request.getCommand().equals("help")) {
                view.showGraveYardMenu();
            } else if (command != null && request.getCommand().equals("exit")) {
                return;
            } else {
                view.printError(ErrorType.COMMAND);
            }
        }
    }


}