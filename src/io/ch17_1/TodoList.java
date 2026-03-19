package io.ch17_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    static final File TODO_DIR = new File("src/io/ch17_1/todoList.txt");
    public static final String CHECKBOX_EMPTY = "[ ]";
    public static final String CHECKBOX_CHECKED = "[V]";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("=== To-Do 리스트 ===");
            System.out.println("1. 할 일 추가");
            System.out.println("2. 전체 목록 보기");
            System.out.println("3. 완료 처리");
            System.out.println("4. 미완료 목록만 보기");
            System.out.println("5. 완료 취소");
            System.out.println("6. 시스템 종료");
            System.out.print("선택 : ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                addTask(sc);
            } else if (choice.equals("2")) {
                printTask();
            } else if (choice.equals("3")) {
                completeTask(sc);
            } else if (choice.equals("4")) {
                pendingTask();
            } else if (choice.equals("5")) {
                cancelTask(sc);
            } else if (choice.equals("6")) {
                break;
            } else {
                continue;
            }

            // 1초의 돌아가는 시간
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("프로그램이 정상적으로 종료되었습니다.");
        sc.close();
    } // end of main


    private static void addTask(Scanner sc) {
        System.out.print("추가할 할 일을 입력하세요 : ");
        String task = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TODO_DIR, true))) {
            bw.write(CHECKBOX_EMPTY + task);
            bw.newLine();
            bw.flush();
            System.out.println("추가되었습니다 : " + task);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void printTask() {
        System.out.println("\n===전체 할 일 목록===");
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(TODO_DIR))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(++count + ". " + line);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void pendingTask() {
        System.out.println("=== 미완료 목록 ===");

        try (BufferedReader br = new BufferedReader(new FileReader(TODO_DIR))) {
            String checkBox;
            int count = 0;
            while ((checkBox = br.readLine()) != null) {
                if (checkBox.contains(CHECKBOX_EMPTY)) {
                    System.out.println(checkBox);
                    count++;
                }
            }
            System.out.println("\n남은 할 일 : " + count + "개");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void completeTask(Scanner sc) {
        printTask();

        System.out.print("완료할 번호를 입력하세요 : ");
        int taskNum = Integer.parseInt(sc.nextLine());
        ArrayList<String> taskList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TODO_DIR))) {
            String line;
            int count = 1;
            while ((line = br.readLine()) != null) {
                if (count == taskNum) {
                    line = line.replace(CHECKBOX_EMPTY, CHECKBOX_CHECKED);
                    taskList.add(line);
                } else {
                    taskList.add(line);
                }
                count++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TODO_DIR))) {
            for (String task : taskList) {
                bw.write(task);
                bw.newLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (taskNum < taskList.size() && taskNum > 0) {
            System.out.println("완료처리 되었습니다 : " + taskList.get(taskNum - 1));
        } else {
            System.out.println("해당 리스트 값은 존재하지 않습니다.");
        }
    }


    private static void cancelTask(Scanner sc) {
        ArrayList<String> taskList = new ArrayList<>();
        printTask();
        System.out.print("완료취소할 할 번호를 입력하세요 : ");
        int taskNum = Integer.parseInt(sc.nextLine());

        try (BufferedReader br = new BufferedReader(new FileReader(TODO_DIR))) {
            int count = 1;
            String line;

            while ((line = br.readLine()) != null) {
                if (count == taskNum) {
                    line = line.replace(CHECKBOX_CHECKED, CHECKBOX_EMPTY);
                    taskList.add(line);
                } else {
                    taskList.add(line);
                }
                count++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TODO_DIR))) {
            for (String task : taskList) {
                bw.write(task);
                bw.newLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (taskNum < taskList.size() && taskNum > 0) {
            System.out.println("완료 취소 처리되었습니다 : " + taskList.get(taskNum - 1));
        } else {
            System.out.println("해당 리스트 값은 존재하지 않습니다.");
        }
    }
} // end of class
