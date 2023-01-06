import java.util.Scanner;

import dao.AccountDao;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AccountDao dao = new AccountDao();
		
		//menu
		while(true) {
			System.out.println("====가계부====");
			System.out.println("1. 가계부 입력");
			System.out.println("2. 가계부 검색");
			System.out.println("3. 가계부 삭제");
			System.out.println("4. 총 가계부 정보 출력");
			System.out.println("5. 가계부 종료");
			System.out.println();
			System.out.print("사용하실 서비스 번호를 입력해주세요.");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					dao.insert("수입");
					break;
				case 2:
					dao.selectMonth();
					break;
				case 3:
					dao.delete();
					break;
				case 4:
					dao.printAll();
					break;
				case 5:
					System.exit(0);
					break;
					default:
						System.out.println("없는 메뉴입니다. 다시 시도하세요.");
						break;
			}
		}
	}

}
