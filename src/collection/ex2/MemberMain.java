package collection.ex2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/***
 *   1. 회원 가입   (Create)
 *   2. 회원 조회   (Read)
 *   3. 회원 수정   (Update)
 *   4. 회원 삭제   (Delete)
 *   5. 전체 목록   (Read All)
 */
public class MemberMain {
    public static void main(String[] args) {
        // map 배열 생성
        Map<Integer, Member> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        ///todo 임시 테스트 임의의 변수 설정
        map.put(1, new Member("홍길동", "fossadf@gmail.com", 22));
        map.put(2, new Member("강감찬", "abcde@gmail.com", 25));

        while (true) {
            System.out.println("=== 회원 관리 시스템 ===");
            System.out.println("전체 회원: " + map.size() + "명");
            System.out.println("1. 회원 가입 2. 회원 조회 3. 회원 수정 4. 회원 삭제 5. 전체 목록 6. 프로그램 종료 ");
            System.out.print("선택 : ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                createMember(sc, map);

            } else if (choice.equals("2")) {
                readMember(sc, map);

            } else if (choice.equals("3")) {
                System.out.println("===============================");
                System.out.println("3. 회원 수정 선택 하였습니다.");



            } else if (choice.equals("4")) {
                System.out.println("===============================");
                System.out.println("4. 회원 삭제를 선택 하였습니다. 삭제할 회원 ID를 입력해주세요!");
                System.out.print("ID: ");
                int removeId = Integer.parseInt(sc.nextLine());
                System.out.println("[완료] 삭제됨: " + map.get(removeId).getName() );
                map.remove(removeId); // 배열에서 삭제하기

            } else if (choice.equals("5")) {
                readAllMember(map);

            } else if (choice.equals("6")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    } // end of main

    private static void readAllMember(Map<Integer, Member> map) {
        System.out.println("===============================");
        System.out.println("5. 전체 목록을 선택 하였습니다.");
        for (int i = 1; i < map.size() + 1; i++) {
            showInfo(map, i);
        }
    }

    private static void readMember(Scanner sc, Map<Integer, Member> map) {
        System.out.println("===============================");
        System.out.println("2. 회원 조회를 선택 하였습니다. 아이디를 입력해주세요!");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine()) - 1;
        showInfo(map, id);
    }

    // 해당 회원 정보 확인
    private static void showInfo(Map<Integer, Member> map, int id) {
        String[] text = new String[4];
        // 텍스트 지정
        // text[0] = "id= " + map.get(id) + ", ";
        text[1] = "name= " + map.get(id).getName() + ", ";
        text[2] = "email= " + map.get(id).getEmail() + ", ";
        text[3] = "age= " + map.get(id).getAge();

        System.out.println("조회 결과: Member{" + text[0] + text[1] + text[2] + text[3] + "}" );
    }

    private static void createMember(Scanner sc, Map<Integer, Member> map) {
        System.out.println("===============================");
        System.out.println("1. 회원 가입을 선택 하였습니다. 다음을 기입해주세요!");
        System.out.print("아이디 : ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("이름 : ");
        String name = sc.nextLine();

        System.out.print("이메일 : ");
        String email = sc.nextLine();

        System.out.print("나이 : ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.println("[완료] 회원 가입: " + name + " (ID: " + (id) + ")");
        // map 배열 아이디, 번호, 이름, 이메일, 나이
        map.put(id, new Member(name, email, age));

    }

} // end of class
