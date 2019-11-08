package test;

import java.util.UUID;

public class Test {
	public static void main(String[] args) {
		// --- UUID 생성 ---
		UUID uuid = UUID.randomUUID(); // 랜덤 UID 생성

		String u = uuid.toString();
		
		String[] res = u.split("-"); // split("-") -> "-"기준으로 쪼개서 res배열에 담는다.
		
		for (String uid : res) {
			System.out.println(uid);
		}
		
		// 12자리 랜덤 UID 만들기
		System.out.println("--- 12자리 ---");
		System.out.println(res[4]);
		System.out.println(res[1]+res[2]+res[3]);
		
		// 20 자리 랜덤 UID 만들기
		System.out.println("--- 20자리 ---");
		System.out.println(res[1]+res[2]+res[4]);
		
	}
}
