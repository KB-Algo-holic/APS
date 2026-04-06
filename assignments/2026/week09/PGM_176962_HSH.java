package week09;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PGM_176962_HSH {

    public static void main(String[] args) {
        String plans[][] = {
                { "korean", "11:40", "30" },
                { "english", "12:10", "20" },
                { "math", "12:30", "40" }
        };

        // 객체 생성
        PGM_176962_HSH sol = new PGM_176962_HSH();

        // 함수 호출
        String[] answer = sol.solution(plans);

        // 결과 출력
        System.out.println(Arrays.toString(answer));
    }

    public String[] solution(String[][] plans) {
        int planSize = plans.length;
		Task[] tasks = new Task[planSize];
		for (int i = 0; i < planSize; i++) {
			String name = plans[i][0]; // 공부할 과목
			int start = timeToMinutes(plans[i][1]); // 시작하는 시간 -> 12시 20분 : 12 * 60 + 20 * 1
			int runTime = Integer.parseInt(plans[i][2]); // 실행 시간 -> 분으로 계산 (이거는 애초에 분으로 입력되므로 그대로 진행)

			tasks[i] = new Task(name, start, runTime); // 인풋으로 들어올 과제를 미리 배열에 넣어두고 이걸 스택에 넣을건데
			/*
			 * 1) Comparator패턴으로 입력할 과목들 먼저 정렬 처리 할 것 2) 진행중인 과제 -> 배열로 미리 정렬처리 3) 잠시
			 * 멈춤 과제 또한 LIFO이므로 스택에 넣을 것 4) 우선순위는 항상 시작 시간에 도달한 과목임
			 *
			 */
		}
		// 1) 정렬 처리
		Arrays.sort(tasks, (a, b) -> (a.start - b.start));
		// 2) 진행중인 과제 스택
		Stack<Task> pauseStack = new Stack<>(); // 멈춤 과제 스택 
		Queue<String> completeTask = new LinkedList<>(); // 작업 완료 태스크 관리
		for (int i = 0; i < planSize - 1; i++) {
			// 현재 시작할 업무
			Task currentTask = tasks[i];
			// 다음 시작할 업무 ->
			Task nextTask = tasks[i + 1];
			// 다음 시작하는 업무의 시작시간 ~ 현재 시작한 업무의 시작시간: 작업 처리 가능한 시간
			int taskAvailableTime = nextTask.start - currentTask.start;
			/* 작업 처리 가능한 시간 >= 현재 시작하는 업무의 작업 시간 = 잠시 멈춤 과제의 스택에 넣을 필요가 없음 
			 * 작업 처리 가능한 시간 < 현재 시작하는 업무의 작업 시간 = 현재 업무가 잠시 멈춤 과제의 스택에 넣어줘야함
			 */
			
			if(currentTask.runTime > taskAvailableTime) {

				int remainTime =  currentTask.runTime - taskAvailableTime; //처리는 우선하다가 남은 시간은 현재 업무 시간에서 작업 가능한 시간을 빼줘야징
				// 예: 첫 번쨰 과목 720, 60분소요  두 번째 과목 760, 40분 소요라하면
				// 760 - 720 = 40 -> 사용 가능한 시간 
				// 첫 번째 과목 작업시간 60분 = 60 - 40 : 20분 남는 타임 -> 추후에 관리
				Task pauseTask = new Task(currentTask.name, currentTask.start, remainTime); // 사실 여기선 시작 시간 필요 없음 -> 남는 시간만 중요
				pauseStack.push(pauseTask);
				
				// 다음 작업을 해야하는데 그건 for문으로 처리하고 여기서 처리할 건.. 
			} 
			// 현재 작업 완료한 태스크의 이름을 넣어주면 되는데, 어차피 FIFO로 나올거라 큐로 처리 
			else {
				completeTask.add(currentTask.name); // 완성이 되었겠지만.. 음.. 만약 다음 작업전까지 시간이남았다면..?
				int remainTime = taskAvailableTime - currentTask.runTime; // 여기서 남는 시간은 추가로 작업할 수 있는 시간!! 
				/*
				 * 작업 가능한 시간 동안에 일시정지 스택에 남은 작업이 있을 때 까지 업무처리 
				 */
				while(!pauseStack.isEmpty()) {
					if(remainTime > 0) {
						// 남은 시간만큼에 대해서 일시정지 스택에 있는 작업을 LIFO로 처리할 것
						Task pauseTask = pauseStack.pop(); 
						// 일시정지된 작업의 남은 시간보다 작업하고 남은 시간이 더 많다면 일시정지된 작업은 업무처리 모두 완료!
						if(pauseTask.runTime <= remainTime) {
							remainTime = remainTime - pauseTask.runTime; // 남은 시간은 그만큼 감소
							completeTask.add(pauseTask.name); // 작업 완료한 이름만 넣어두면 됨
						}
						// 엇..일시정지된 작업량이 더 많다..?
						else {
							Task rePauseTask = new Task(pauseTask.name, pauseTask.start, (pauseTask.runTime - remainTime));
							pauseStack.push(rePauseTask);
							// remainTime은 초기화가 필요
							remainTime = -1;
						}
					} else {
						break;
					}
				}
			}
		}
		
		// 남은 작업 처리하기 -> 마지막 작업은 넣어줄 것 (for문 다 돌고 while문 다돌면 남는거는 그냥 넣어주기)
		completeTask.add(tasks[planSize - 1].name) ;
		// pauseStack에 남은것 모두 넣어주기 
		while(!pauseStack.isEmpty()) {
			completeTask.add(pauseStack.pop().name);
		}
		
        return completeTask.toArray(new String[0]);
    }
    
    	static int timeToMinutes(String time) {
		// "12:20" 이런식으로 들어올테니까 앞에는 분으로 변환 뒤에는 그냥 분
		int hour = Integer.parseInt(time.split(":")[0]);
		int minute = Integer.parseInt(time.split(":")[1]);
		int result = hour * 60 + minute * 1;
		return result;
	}
    
    // 이중 배열로 들어온 plans에는 하나의 Task로 처리해서
	// 배열로 넣을 예정
	static class Task {
		String name;
		int start;
		int runTime;

		Task(String name, int start, int runTime) {
			this.name = name;
			this.start = start;
			this.runTime = runTime;
		}
	}
}
