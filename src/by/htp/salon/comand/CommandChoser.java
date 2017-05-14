package by.htp.salon.comand;
import static by.htp.salon.util.ConstantValue.*;

public class CommandChoser {
	public static CommandAction chooseAction(String action){
		switch(action){
		case ACTION_AUTHORISE:
			System.out.println("Login action "+action);
			return new LoginCommandAction();
		
		case ACTION_MAKE_ORDER:
			System.out.println("createOrder action" + action);
			return new OrderCreatedAction();
		
		case ACTION_ORDER:
			System.out.println("meke order action" + action);
			return new MakeOrderAction();
		}
	return null;	
	}
}
