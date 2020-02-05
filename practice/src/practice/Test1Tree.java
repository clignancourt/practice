package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
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
			
			// 노드별 코드를 각각의 set(중복제거)리스트에 저장하기 위해 n개의 Set 선언 및 초기화
			Set<String>[] node = new HashSet[5];
			for (int i = 0;  i < node.length; i++) {
				node[i] = new HashSet<String>();
			}

			while ((line = br.readLine()) != null) {
				
				String[] field = line.split(",");
				String[] classCode = field[0].split("-");
				// field[1]: 컨텐츠 고유키
				// field[0]: 분류 코드
				// classCode[i]: 노드별 코드
				
				// EX) 4R18-4R-A-C-D,cn100547606c
				//     node1.add("4R18,cn100547606c");
				// 파일로부터 읽어 온 한 문장에 대해 각 node들의 리스트에 해당 노드별 코드+컨텐츠 고유키 저장
				
				for(int i=0; i<node.length; i++) {
					String nodeString = "";
					
					for(int j=0; j<=i; j++) {
						// 첫번째 노드 앞에는 "-" 안 붙여도 됨
						if(j==0) nodeString += classCode[j];
						else nodeString += ("-"+classCode[j]);
					}
					nodeString += ("," + field[field.length - 1]);
					node[i].add(nodeString);
				}
				
			}
			
			// set으로 중복 제거한 리스트를 정렬하기 위해 arrayList로 변경 후 정렬 
			List<String> arr[] = new ArrayList[node.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = new ArrayList<String>(node[i]);
				arr[i].sort(null);
			}

			
			for (int i = 0; i < node.length; i++) {
				
				String key = "";
				int cnt = 0;
				int checkLast = 0;

				for(int j=0; j<arr[i].size(); j++) {
					String[] val = arr[i].get(j).split(",");
					
					if (!key.equals(val[0])) {
						// key의 값이 공백이 아니라면 key과 cnt를 출력
						if (!key.equals("")) {
							System.out.println(key + "," + cnt);
							// cnt1 초기화
							cnt = 1;
						}
						// 공백이라면 첫번째 값이니깐 cnt++
						else cnt++;
						// val[0]의 값을 key1에 넣기
						key = val[0];
					}
					// 같다면 cnt++
					else cnt++;
					checkLast++;
					if (checkLast == arr[i].size()) System.out.println(key + "," + cnt);
				}
			}
			
			
		}
	}
	
}
