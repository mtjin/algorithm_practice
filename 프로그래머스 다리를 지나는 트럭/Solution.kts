import java.util.*

class Solution {

    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val readyQueue: Queue<Truck> = LinkedList<Truck>()  //출발전 대기큐
        val onBridgeQueue: Queue<Truck> = LinkedList<Truck>() //다리위 출발큐
        var onBridgeTotalTruckWeight = 0 //다리 위 현재 무게
        var time = 0

        //값 세팅
        for (weight in truck_weights) {
            readyQueue.offer(Truck(weight, 0))
        }

        //미리 출발큐에 하나 추가
        if(readyQueue.size >= 0) {
            onBridgeTotalTruckWeight += readyQueue.peek().weight
            onBridgeQueue.offer(readyQueue.poll())
        }else{
            return 0
        }

        while (!onBridgeQueue.isEmpty()) {
            //다리 위 트럭이동
            for (truck2: Truck in onBridgeQueue) {
                truck2.postion++
            }
            //도착한 트럭 빼기
            if (onBridgeQueue.peek().postion >= bridge_length) {
                onBridgeTotalTruckWeight -= onBridgeQueue.poll().weight
            }
            //대기큐에 트럭이 있을 경우
            if (!readyQueue.isEmpty()) {
                // 다리가 무게 견딜수 있는 트럭인 경우 트럭 poll(출발)
                if (readyQueue.peek().weight + onBridgeTotalTruckWeight <= weight) {
                    with(readyQueue.poll()){
                        onBridgeTotalTruckWeight += this.weight
                        onBridgeQueue.offer(this)
                    }
                }
            }
            //총 걸린 시간 증가(결과)
            time++
        }

        return time + 1 //마지막 빠져나오는 시간떄문에 +1
    }

    //트럭무게, 현재위치
    data class Truck(var weight: Int, var postion: Int)
}