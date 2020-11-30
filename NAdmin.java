public class NAdmin {
		private String password;
		
		NAdmin(){
			this.password = "1234";
		}
		
		public void MasterPassword() {
			System.out.print("관리자 암호를 입력하세요 : ");
			String inputPassword = NLogin.sc.nextLine();
			System.out.println();
			if(this.password.equals(inputPassword)) {
				
				showStatus();
				showMasterMenu();
				
			}else {
				System.out.println("올바르지 못한 입력값입니다.");
				backLogin();
			}
		}
		
		private void showStatus() { 
			System.out.println("-----[Summary Information]-----\n");
			System.out.println("시스템 전원 : On");

			System.out.println("현재 회원 수 : " + NUser.userArr.size() );
		}
		
		private void showMasterMenu() {
			do {
//				showStatus();
				System.out.println("\n------------------------------\n");
				System.out.println("      [관리자 전용메뉴]\n");
				System.out.println("0. 회원정보 열람");

				System.out.println("3. 로그인 화면으로 돌아가기\n");
				System.out.println("9. 시스템 전원 Off \n");
				System.out.print("메뉴를 선택하세요 : ");
				String inputMenu = NLogin.sc.nextLine();
				System.out.println();
			
				switch(inputMenu) {
				case "0" : showMemberInfo(); showMasterMenu(); break; 

				case "3" : backLogin(); break; // 로그인 화면으로 돌아가기
				case "9" : NLogin.progressBar("모든 프로그램을 종료합니다.", 1000);System.exit(1);; break; // 로그인 화면으로 돌아가기
				default: System.out.println("입력값을 확인하세요."); showMasterMenu();
				}
			}while(false);
		}
		private void showMemberInfo() {
			System.out.println("\n------------------------------\n");
			NLogin.progressBar("DB 서버와 통신 중");
			System.out.println("[Status_Code : 200]");
			System.out.println("\n------------------------------\n");
			System.out.println("		[도서 관리 시스템 회원 DB서버]\n");
			System.out.println("(인원) 아이디   - (비밀번호 / 이름 / 핸드폰 / 이메일)\n");
			for(int i=0; i<NUser.userArr.size(); i++) {
				StringBuffer string = new StringBuffer(NUser.userArr.get(i).getPwd());
				String pwd = string.replace(string.length()/2-2, string.length()/2+2, "****").toString();
				System.out.println( "("+(i+1)+") "+NUser.userArr.get(i).getId() +" - ("+pwd
						+" / "+ NUser.userArr.get(i).getName()+" / "+ NUser.userArr.get(i).getPhone()+" / "
						+NUser.userArr.get(i).getEmail()+")");
			}
		}
		
		private void backLogin() {
			NLogin.loginDisplay();
		}
	}
