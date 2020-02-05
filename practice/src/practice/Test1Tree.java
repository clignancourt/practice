package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * Java8 환경입니다.
 * 별도의 의존성이 요구되지 않습니다. 따라서 ant, maven, gradle 등의 사용은 불필요합니다.
 * </pre>  
 * @author challengek
 *	
 */
public class Test1Tree {

	public static void main(String[] args) throws IOException {
		sample1();
	}
	
	public static void sample1() throws FileNotFoundException, IOException {
		String pathPrefix = System.getProperty("java.class.path").split(";")[0];
		String filePath = pathPrefix + File.separator + "tree.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			
			Set<String>[] node = new HashSet[5];
			// 노드별 코드를 각각의 set(중복제거)리스트에 저장하기 위해 n개의 Set 선언
			Set<String> node1 = new HashSet<>();
			Set<String> node2 = new HashSet<>();
			Set<String> node3 = new HashSet<>();
			Set<String> node4 = new HashSet<>();
			Set<String> node5 = new HashSet<>();
			
			while ((line = br.readLine()) != null) {
				
				String[] field = line.split(",");
				String[] classCode = field[0].split("-");
				// field[1]: 컨텐츠 고유키
				// field[0]: 분류 코드
				// classCode[i]: 노드별 코드
				
				// EX) 4R18-4R-A-C-D,cn100547606c
				//     node1.add("4R18,cn100547606c");
				// 파일로부터 읽어 온 한 문장에 대해 각 node들의 리스트에 해당 노드별 코드+컨텐츠 고유키 저장
				
				
				node1.add(classCode[0] + "," + field[field.length - 1]);
				node2.add(classCode[0] + "-" + classCode[1] + 
						"," + field[field.length - 1]);
				node3.add(classCode[0] + "-" + classCode[1] + "-" + classCode[2] + 
						"," + field[field.length - 1]);
				node4.add(classCode[0] + "-" + classCode[1] + "-" + classCode[2] + "-" + classCode[3] + 
						"," + field[field.length - 1]);
				node5.add(classCode[0] + "-" + classCode[1] + "-" + classCode[2] + "-" + classCode[3] + "-" + classCode[4] + 
						"," + field[field.length - 1]);
				
			}
			
			List<String> arr[] = new ArrayList[3];
			
			// set으로 중복 제거한 리스트를 정렬하기 위해 arrayList로 변경 
			List<String> arr1 = new ArrayList<>(node1);
			List<String> arr2 = new ArrayList<>(node2);
			List<String> arr3 = new ArrayList<>(node3);
			List<String> arr4 = new ArrayList<>(node4);
			List<String> arr5 = new ArrayList<>(node5);
			
			// 리스트를 오름차순으로 정렬
			arr1.sort(null);
			arr2.sort(null);
			arr3.sort(null);
			arr4.sort(null);
			arr5.sort(null);
			
			
			
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
			
			
			String key5 = "";
			int cnt5 = 0;
			int checkLast5 = 0;
			
			for(int i=0; i<arr5.size(); i++) {
				String[] val = arr5.get(i).split(",");
				
				if (!key5.equals(val[0])) {
					// key1의 값이 공백이 아니라면 key1과 cnt를 출력
					if (!key5.equals("")) {
						System.out.println(key5 + "," + cnt5);
						// cnt1 초기화
						cnt5 = 1;
					}
					// 공백이라면 첫번째 값이니깐 cnt++
					else cnt5++;
					// val[0]의 값을 key1에 넣기
					key5 = val[0];
				}
				// 같다면 cnt++
				else cnt5++;
				checkLast5++;
				if (checkLast5 == arr5.size()) System.out.println(key5 + "," + cnt5);
			}

			
			
		}
	}
	
}
