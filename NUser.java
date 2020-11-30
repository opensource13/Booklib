# Booklib
import java.util.ArrayList;
public class NUser {
	private String name; //이름
	private String id;  //아이디
	private String pwd; //비밀번호
	private String phone; //핸드폰
	private String email; //이메일
	public static ArrayList<NUser> userArr; //배열은 고정크기 이상 관리 할 수 없지만, 컬렉션은 가변크기로써 객체 개수 염려X
	
	static {
		userArr = new ArrayList<NUser>();
	}

	public NUser(String name, String id, String pwd, String phone, String email) { //생성자
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
		this.email = email;
	}
	
	public static void UserMyInfo() { // 마이페이지
        for (int i = 0; i < userArr.size(); i++) {
            if (NLogin.userId.equals(userArr.get(i).getId())) {
                System.out.println("\n------------------------------\n");
                System.out.println("    [마이페이지]\n");
                System.out.printf("%-7s: %-5s\n%-6s: %-5s\n%-6s: %-12s\n%-6s: %-20s\n", "[이름]",
                        userArr.get(i).getName(), "[아이디]", userArr.get(i).getId(), "[전화번호]", userArr.get(i).getPhone(),
                        "[이메일]", userArr.get(i).getEmail());
            }
        }
        System.out.println("\n* 이전화면으로 돌아가려면, 엔터(Enter)키를 입력하세요.");
        System.out.println("* \"회원탈퇴\"를 를 입력시 회원탈퇴가 가능합니다.");
        System.out.print("\n>>> Press any key to continue : ");
        String word = NLogin.sc.nextLine();
        if(word.equals("회원탈퇴")) {
            System.out.println("\n정말로 탈퇴하시겠습니까? (yes/no)");
            System.out.print(">>> ");
            switch (NLogin.sc.nextLine().toLowerCase()) {
            case "yes":
            case "y":
                for(int i=0; i<userArr.size(); i++) {
                    if(NLogin.userId.equals(userArr.get(i).getId())) {
                        userArr.remove(i);
                        DataBaseExcel.dataBase_Write("RegisterDataBase");
                    }
                }
                System.out.println("\n>>> 회원탈퇴가 정상적으로 처리되었습니다.");
                NLogin.loginDisplay();
                break;
            default:
            	return;
            }
        }
    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}
