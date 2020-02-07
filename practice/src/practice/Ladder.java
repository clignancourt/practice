/**
 * 
 */
package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author scien
 *
 */
public class Ladder {
	
	public static void main(String[] args) {
		
		// int[][] ladder = new int[5][12];
		
		// solve(n, answer);  // n은 계단수

		// 열의 길이는 정해져 있음 (사다리 수=참가자) 5개 
		int participants = 5;
		
		// 입력받은 계단 수 
		int n = 12;
		
		int[] steps = randomSteps(n, participants);
		int[][] ladder = makeLadder(steps, participants);
		
		for(int i=0; i<ladder[0].length; i++) {
			for(int j=0; j<ladder.length; j++) {
				System.out.print(" ["+i+","+j+"] ");
			}
			System.out.println();
		}
		
	}
	
	

	// 이차배열을 만드는 메서드
	private static int[][] makeLadder(int[] steps, int participants) {
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
	// 입력받은 계단 수를 랜덤으로 돌려서 3개의 값으로 나눈 뒤에
	// 그 중 가장 큰 값과 (큰)옆 칸을 더하여 이차배열의 행의 값(y)이 되어서 이차배열을 선언
	public static int[] randomSteps(int totalSteps, int participants) {
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
