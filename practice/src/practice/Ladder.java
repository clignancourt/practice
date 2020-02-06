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
		
		int[][] ladder = new int[4][11];
		
		// 열 길이 ladder.length
		// 행 길이 ladder[0].length
		
		
		
	}

	
	// 정해진 행렬에 대하여 랜덤으로 계단 수를 생성하는 메서드
	public static int[] randomSteps(int row, int column) {
		int[] step = new int[column-1];
		
		int max = ((column-1)*(row-2)/2); // 최대로 만들 수 있는 계단의 수 13
		int totalStep = ((int)(Math.random()*(max-(step.length-1)) )+step.length); // 3~13까지 출력

		int temp = totalStep;
		for(int i=step.length; i>0; i--) {
			if(i==1) {
				step[i-1] = totalStep - (step[i]+step[i+1]);
			}
			else step[i-1] = ( (int)(Math.random()*(temp-i)) +1);
			temp -= step[i-1];
		}
		return step;
	}

}
