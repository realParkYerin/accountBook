package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AccountDto;

public class AccountDao {
	Scanner sc = new Scanner(System.in);
	//객체생성
	private List<AccountDto> list = new ArrayList<AccountDto>();
	
	private int count;
	
	//CRUD
	//함수 이름 : insert
	//목적 : 가계부에 적을 정보들 추가(date, use, classify, money, memo)
	public void insert(String classify) {
		System.out.print("날짜를 입력하세요.>>>");
		String date = sc.next(); //date user input
		
		System.out.print("돈을 어디에 사용하셨나요?(쓰임)>>>");
		String use = sc.next();//use user input
		
		//System.out.print("1.수입인가요? 2.지출인가요?>>>");
		//String classify = sc.next(); //classify user input
		
		System.out.print("금액을 적으세요.");
		int money = sc.nextInt(); //money user input
		
		System.out.print("간단하게 메모를 작성해주세요.");
		String memo = sc.next(); //memo user input
		
		//위 내용들 정보 list 저장
		AccountDto dto = new AccountDto(date, use, classify, money, memo);
		list.add(dto);
	}
	
	//가계부 모든 데이터 출력
	public void printAll() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + "." + list.get(i).toString());
		}
	}
	
	//함수 이름 : delete
	//목적 : 가계부에 있는 정보 삭제
	public void delete() {
		System.out.println("삭제할 메모를 입력하세요.");
		String memo = sc.next();
		
		int index = search(memo);
		
		if(index == -1) {
			System.out.println("동일한 메모를 찾을 수 없습니다.");
		}else {
			list.remove(index);
			System.out.println("동일한 메모를 가진 가계부 정보를 삭제했습니다.");
		}
	}
	
	//수입, 지출 분류
	public void selectClassify() {
		System.out.print("수입인가요? 지출인가요?(수입/지출만 입력)>>>");
		String classify = sc.next(); //classify user input
		
		while(true) {
			if(classify.equals("수입")) {
				insert(classify);
				break;
			} else if(classify.equals("지출")) {
				insert(classify);
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
	}
}
	
	//검색 입력한 날짜 연도연별 결산
	public void selectMonth() {
		System.out.print("결산을 알고싶은 날짜를 입력하세요(yy/mm/dd)");
		String date = sc.next();
		
		//수입, 지출 구분해서 넣어주는 리스트
		List<AccountDto> income = new ArrayList<>();
		List<AccountDto> outcome = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getClassify().equals("수입")) {
				income.add(list.get(i));
			} else {
				outcome.add(list.get(i));
			}
		}
		
		//월간 총수입, 총지출 나타내기
		//수입
		List<AccountDto> incomeList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String checkDate = income.get(i).getDate();
			if(checkDate == date) {
				incomeList.add(income.get(i));
			}
		}
		for(AccountDto dto : incomeList) {
			System.out.println(dto);
		}
		
		//지출
		List<AccountDto> outcomeList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String checkDate = outcome.get(i).getDate();
			if(checkDate == date) {
				outcomeList.add(outcome.get(i));
			}
		}
		for(AccountDto dto : outcomeList) {
			System.out.println(dto);
		}
		
		//총수입
		int total =0;
		for (int i = 0; i < incomeList.size(); i++) {
			total = total + incomeList.get(i).getMoney();
		}
		System.out.println("총 수입은:" + total + "원 입니다.");
		
		//총지출
		total = 0;
		for (int i = 0; i < outcomeList.size(); i++) {
			total = total + outcomeList.get(i).getMoney();
		}
		System.out.println("총 수입은:" + total + "원 입니다.");
	}
	
	/*
	public void selectUse() {
		}
		//수입
		
		//지출
	
	public void select() {
		//용도
	}
	
	/*
	public void update() {
		
	}*/
	
	
public int search(String memo) {
	int index = -1;
	for (int i = 0; i < list.size(); i++) {
		AccountDto ac = list.get(i);
		if(memo.equals(ac.getMemo())) {
			index = i;
			break;
		}
	}
	return index;
}
}