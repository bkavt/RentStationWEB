package by.htp.salon.comand;

public class CommandChoser {
	public static CommandAction chooseAction(String action){
		switch(action){
		case "login":
			System.out.println("Login action "+action);
			return new LoginCommandAction();
		}
	return null;	
	}
}
