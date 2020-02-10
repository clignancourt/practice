/**
 * 
 */
package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author scien
 *
 */
public class Ladder {
	
	public static void main(String[] args) {
		
		// 각 참가자의 수와 계단을 모두 2차원 배열에 표현하고 출발지에서 시작해 
		// 각 단계별로 계단 유무를 판별하여 이동을 거쳐 최종 도착지의 값을 구하는 방식으로 구현
		
		// solve(n, answer);  // n은 계단수

		// 열의 길이는 정해져 있음 (사다리 수=참가자) 5개 
		int participants = 5;
		
		// 입력받은 계단 수 
		int inputLadders = 12;
		
		int[] steps = divideRandomSteps(inputLadders, participants);
		int[][] ladderFrame = makeFrame(steps, participants);
		
		int[][] ladder = makeLadder(ladderFrame, steps);

		for(int i=0; i<ladder[0].length; i++) {
			for(int j=0; j<ladder.length; j++) {
				System.out.print(ladder[j][i]+" ");
			}
			System.out.println();
		}
		
		int participant = 0;
		play(participant, ladderFrame);
		
	}
	
	
	// 한 사용자가 출발해서 몇 번째 사다리로 끝나는 지에 대한 메서드
	private static void play(int participant, int[][] ladder) {
		
		int temp = 0;
		
		for(int i=0; i<ladder.length; i++) {
		
			for(int j=temp; j<ladder[0].length; j++) {
				if(ladder[i][j]==0) break;
			}
			
			
		}
		
	}


	
	
	// 랜덤 사다리 만드는 메서드
	private static int[][] makeLadder(int[][] ladderFrame, int[] steps) {
		int row = ladderFrame[0].length;
		
		// 랜덤으로 정해지는 계단의 위치를 열 별로 저장할 리스트 (key값은 열의 값)
		Map<Integer, Set<Integer>> map = new HashMap<>();
		
		for(int i=0; i<steps.length; i++) {
	
			while(true) {
				// 1 ~ (row-2)사이  임의의 숫자 
				int random = (int)(Math.random()*(row-2)+1);
				
				// 첫번째 열이 아니라면  
 				if( !(i==0) ) {
 					
 					// 옆 열(i-1)과 행이 겹치는지 확인 (옆 열과 행이 중복되면 안됨)
					while(true) {
						// 겹치지 않으면, 반복문 탈출 
						if(!(map.get(i-1).contains(random)))
							break;
						else 
							random = (int)(Math.random()*(row-2)+1);
					}
				}
				
				if (!map.containsKey(i))
					map.put(i, new HashSet<Integer>());
				map.get(i).add(random);	
				
				// 계단 위치한 곳에 값 1을 넣어준다
				ladderFrame[i][random] = 1;
				
				// 끝에서 두번째 열이라면 마지막 열에 같은 값을 넣어줌
				if(i==steps.length-1) 
					ladderFrame[i+1][random] = 1;
				
				// 랜덤으로 모든 계단의 위치가 정해졌다면 반복문 빠져나가서 옆 열로 이동
				if(map.get(i).size() == steps[i]) 
					break;
			}
			
		}
		System.out.println(map);
		return ladderFrame;
	}



	// 이차배열을 만드는 메서드 (사다리의 틀)
	private static int[][] makeFrame(int[] steps, int participants) {
		// 배열을 arrayList로 변경하여 가장 큰 값을 찾아줌 
		List<Integer> stepList = IntStream.of(steps).boxed().collect(Collectors.toCollection(ArrayList::new));
		int max1 = Collections.max(stepList);
		// 최고값 지우고 그 다음 최고값 찾기 
		stepList.remove(stepList.indexOf(max1));
		int max2 = Collections.max(stepList);
		
		// 행의 길이는 가장 큰 계단 수 + 그 다음으로 큰 계단 수
		// 배열을 선언
		int[][] makeLadder = new int[participants][max1+max2+2];
		
		return makeLadder;
	}


	// 랜덤으로 계단 수 분배하는 메서드 
	// 처음부터 배열의 크기를 정해놓으면 안됨
	// 입력받은 계단 수를 랜덤으로 돌려서 (총 참가자의 수-1)개의 값으로 나눈 뒤에
	// 그 중 가장 큰 값과 (큰)옆 칸을 더하여 이차배열의 행의 값(y)이 되어서 이차배열을 선언
	public static int[] divideRandomSteps(int totalSteps, int participants) {

		int[] step = new int[participants-1];
		
		int sum = 0;
		
		for(int i=step.length-1; i>=0; i--) {
			if(i==0) step[i] = totalSteps - sum;
			else {
				step[i] = ((int)(Math.random()*(totalSteps-sum-i))+1);
				sum += step[i];
			}
			System.out.println(step[i]);
		}
		return step;
	}
	
	
	
}
