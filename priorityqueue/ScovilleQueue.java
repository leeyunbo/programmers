package priorityqueue;

import java.util.PriorityQueue;

/**
 * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
 * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한 사항
 * scoville의 길이는 1 이상 1,000,000 이하입니다.
 * K는 0 이상 1,000,000,000 이하입니다.
 * scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
 * 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
 * @author 이윤복
 *
 */

class Food implements Comparable<Food> {
	int scoville;  
	
	public Food(int _scoville) {
		scoville = _scoville;
	}
	
	@Override
	public int compareTo(Food target) {
		if (this.scoville > target.scoville) {
			return 1;
		} else if (this.scoville < target.scoville) {
			return -1; 
		}
		return 0;
	}
}

public class ScovilleQueue {
	static int myScoville[] = {1,2};
	static int myK = 7;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		PriorityQueue<Food> queue = getPriorityQueue();
		while(changeScoville(queue)) {
			answer++;
			if(isFinish(queue)) break;
		}
		
		if(queue.size() == 1 && !isFinish(queue))
			answer = -1;
		
		System.out.println(answer);

	}
	
	private static boolean changeScoville(PriorityQueue<Food> queue) {
		if(queue.size() >= 2) {
			int scoville = queue.poll().scoville + (queue.poll().scoville *2);
			queue.add(new Food(scoville));
			return true;
		}
		else return false;
	}
	
	private static PriorityQueue<Food> getPriorityQueue() {
		PriorityQueue<Food> queue = new PriorityQueue<Food>();
		for(int i=0; i<myScoville.length; i++) {
			queue.add(new Food(myScoville[i]));
		}
		return queue;
	}
	
	private static boolean isFinish(PriorityQueue<Food> queue) {
		if(queue.peek().scoville >= myK) {
			return true;
		}
		return false;
	}
}


