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
			System.out.println("meke order action " + action);
			return new MakeOrderAction();
		
		case ACTION_RETURN_EQUIP:
			System.out.println("return action action " + action);
			return new ReturEquipAction();
		case ACTION_MAKE_RETURN:
			System.out.println("return action action " + action);
			return new MakeReturnAction();
		case ACTION_BACK_MENU:
			System.out.println("back menu action " + action);
			return new BackMenuAction();
			
		case ACTION_START_APP:
			System.out.println("meke order action " + action);
			return new MakeOrderAction();
		case ACTION_LOG_OUT:
			System.out.println("meke order action " + action);
			return new LoginPageAction();
		}
	return null;	
	}
}
