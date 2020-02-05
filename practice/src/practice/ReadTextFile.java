/**
 * 
 */
package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author scien
 *
 */
public class ReadTextFile {
	
	public static void main(String[] args) {

		try {
			// 파일 객체 생성
			File file = new File("C:\\Users\\scien\\OneDrive\\문서\\test.txt");
			// 입력 스트림 생성
			FileReader fr = new FileReader(file);
			// 입력 버퍼 생성
			BufferedReader br = new BufferedReader(fr);
			String line = "";

			Map<String, Set<String>> map = new HashMap<>();

			Set<String> one = new HashSet<>();
			Set<String> two = new HashSet<>();
			Set<String> three = new HashSet<>();
			Set<String> four = new HashSet<>();

			while ((line = br.readLine()) != null) {
				String[] field = line.split(",");
				String[] classCode = field[0].split("-");

				one.add(classCode[0] + "," + field[field.length - 1]);
				two.add(classCode[0] + "-" + classCode[1] + "," + field[field.length - 1]);
				three.add(classCode[0] + "-" + classCode[1] + "-" + classCode[2] + "," + field[field.length - 1]);
				four.add(classCode[0] + "-" + classCode[1] + "-" + classCode[2] + "-" + classCode[3] + ","
						+ field[field.length - 1]);
			}

			br.close();
			
			// set을 이용해서 중복을 제거해준 리스트를 정렬하기 위해 arrayList로 바꿔줌 
			List<String> arr1 = new ArrayList<>(one);
			List<String> arr2 = new ArrayList<>(two);
			List<String> arr3 = new ArrayList<>(three);
			List<String> arr4 = new ArrayList<>(four);
			
			arr1.sort(null);
			arr2.sort(null);
			arr3.sort(null);
			arr4.sort(null);
			
			String key1 = "";
			int cnt1 = 0;
			int checkLast1 = 0;

			for(int i=0; i<arr1.size(); i++) {
				String[] val = arr1.get(i).split(",");
				
				if (!key1.equals(val[0])) {
					// key1의 값이 공백이 아니라면 key1과 cnt를 출력
					if (!key1.equals("")) {
						System.out.println(key1 + "," + cnt1);
						// cnt1 초기화
						cnt1 = 1;
					}
					// 공백이라면 첫번째 값이니깐 cnt++
					else cnt1++;
					// val[0]의 값을 key1에 넣기
					key1 = val[0];
				}
				// 같다면 cnt++
				else cnt1++;
				checkLast1++;
				if (checkLast1 == arr1.size()) System.out.println(key1 + "," + cnt1);
			}
			

			String key2 = "";
			int cnt2 = 0;
			int checkLast2 = 0;

			for(int i=0; i<arr2.size(); i++) {
				String[] val = arr2.get(i).split(",");
				
				if (!key2.equals(val[0])) {
					// key1의 값이 공백이 아니라면 key1과 cnt를 출력
					if (!key2.equals("")) {
						System.out.println(key2 + "," + cnt2);
						// cnt1 초기화
						cnt2 = 1;
					}
					// 공백이라면 첫번째 값이니깐 cnt++
					else cnt2++;
					// val[0]의 값을 key1에 넣기
					key2 = val[0];
				}
				// 같다면 cnt++
				else cnt2++;
				checkLast2++;
				if (checkLast2 == arr2.size()) System.out.println(key2 + "," + cnt2);
			}
			
			
			String key3 = "";
			int cnt3 = 0;
			int checkLast3 = 0;
			
			for(int i=0; i<arr3.size(); i++) {
				String[] val = arr3.get(i).split(",");
				
				if (!key3.equals(val[0])) {
					// key1의 값이 공백이 아니라면 key1과 cnt를 출력
					if (!key3.equals("")) {
						System.out.println(key3 + "," + cnt3);
						// cnt1 초기화
						cnt3 = 1;
					}
					// 공백이라면 첫번째 값이니깐 cnt++
					else cnt3++;
					// val[0]의 값을 key1에 넣기
					key3 = val[0];
				}
				// 같다면 cnt++
				else cnt3++;
				checkLast3++;
				if (checkLast3 == arr3.size()) System.out.println(key3 + "," + cnt3);
			}

			
			
			String key4 = "";
			int cnt4 = 0;
			int checkLast4 = 0;
			
			for(int i=0; i<arr4.size(); i++) {
				String[] val = arr4.get(i).split(",");
				
				if (!key4.equals(val[0])) {
					// key1의 값이 공백이 아니라면 key1과 cnt를 출력
					if (!key4.equals("")) {
						System.out.println(key4 + "," + cnt4);
						// cnt1 초기화
						cnt4 = 1;
					}
					// 공백이라면 첫번째 값이니깐 cnt++
					else cnt4++;
					// val[0]의 값을 key1에 넣기
					key4 = val[0];
				}
				// 같다면 cnt++
				else cnt4++;
				checkLast4++;
				if (checkLast4 == arr4.size()) System.out.println(key4 + "," + cnt4);
			}

			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
