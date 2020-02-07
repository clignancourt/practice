/**
 * 
 */
package practice;

/**
 * @author scien
 *
 */
public class Ladder {
	
	public static void main(String[] args) {
		
		// int[][] ladder = new int[5][12];
		
		// solve(n, answer);  // n은 계단수
		
		// 열 길이 ladder.length
		// 행 길이 ladder[0].length
		
		// 열의 길이는 정해져 있음 (사다리 수) 5개 
		int ladder = 5;
		
		// 입력받은 계단 수 
		int n = 10;
		
		randomSteps(n, ladder);
		
	}

	
	// 처음부터 배열의 크기를 정해놓으면 안됨
	// 입력받은 계단 수를 랜덤으로 돌려서 3개의 값으로 나눈 뒤에
	// 그 중 가장 큰 값과 (큰)옆 칸을 더하여 이차배열의 행의 값(y)이 되어서 이차배열을 선언
	public static int[] randomSteps(int totalSteps, int ladders) {
		int[] step = new int[ladders-1];
		
		int sum = 0;
		for(int i=step.length-1; i>=0; i--) {
			if(i==0) step[i] = totalSteps - sum;
			else {
				step[i] = ((int)(Math.random()*(totalSteps-sum-i))+1);
				sum += step[i];
			}
		}
		return step;
	}

	
	
}
