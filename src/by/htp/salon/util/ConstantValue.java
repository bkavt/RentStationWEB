package by.htp.salon.util;

public final class ConstantValue {

	private ConstantValue() {
	}

	public static final String PAGE_ADMIN_MAIN = "/admin.jsp";
	public static final String PAGE_USER_MAIN = "/user.jsp";
	public static final String PAGE_ERROR = "/error.jsp";

	public static final String REQUEST_PARAM_ACTION = "";
	public static final String REQUEST_PARAM_AUTHORISE = "";
	public static final String REQUEST_PARAM_LOGIN = "login";
	public static final String REQUEST_PARAM_PASSWORD = "pass";
	public static final String REQUEST_PARAM_LIST_EQ = "list_eq";
	public static final String REQUEST_PARAM_ERROR_MSG = "error_msg";

	public static final String RENT_STATION = "rent-station";
	public static final String CLIENTS = "clients";
	public static final String CLIENT = "client";
	public static final String NAME = "name";
	public static final String SONAME = "soname";
	public static final String DOCUMENT = "documetn";
	public static final String ID = "id";
	public static final String EQUIPMENTS = "equipments";
	public static final String UNITS = "units";
	public static final String BIKE = "bike";
	public static final String SKATE = "skate";
	public static final String ROLLERS = "rollers";
	public static final String TITLE = "title";
	public static final String COST = "cost";
	public static final String WEIGHT = "weight";
	public static final String SIZE = "size";
	public static final String ACCESSORY = "accessory";
	public static final String HELMET = "helmet";
	public static final String ELBOW_PADS = "elbow_pads";
	public static final String KNEE_PADS = "knee_pads";
	public static final String ORDER = "order";
	public static final String ORDERS = "orders";
	public static final String FILE_CLIENT_LIST = "salon_rentail_clients.xml";
	public static final String FILE_FREE_EQUIP_LIST = "salon_rentail_free_equip.xml";
	public static final String FILE_RENT_EQUIP_LIST = "salon_rentail_rent_equip.xml";
	public static final String FILE_ORDER_LIST = "salon_order_equip.xml";

	public static final String SQL_STATMENT_SELECT_USERS="select * from user";
	public static final String SQL_STATMENT_SELECT_USER="select * from user where login= ? and password= ?";
}
