class Solution {
    fun solution(nums: IntArray): Int {
        for (i in 0 until nums.size - 2) {
            for (j in i + 1 until nums.size - 1) {
                for (k in j + 1 until nums.size) {
                    isSosu(nums[i] + nums[j] + nums[k])
                }
            }
        }
        return answer
    }

    fun isSosu(num: Int) {
        var i = 2
        while (i * i <= num) {
            if (num % i == 0) {
                //소수아님
                return
            }
            i += 1
        }
        //소수
        answer++
    }

    companion object {
        var answer = 0
    }
}