class Solution {
    //skill : 필수선마스킬들, skill_tress :
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int prevSkillIndex = -1; // 최근에 배운 필수선마스킬(skill) 인덱스

        for (int i = 0; i < skill_trees.length; i++) {
            prevSkillIndex = -1;
            String skillTree = skill_trees[i];
            for (int j = 0; j < skill.length(); j++) {
                String skill2 = String.valueOf(skill.charAt(j));
                if (skillTree.contains(skill2)) {
                    if (skillTree.indexOf(skill2) > prevSkillIndex) {
                        if (j > 0) { //2번째 이상 필수선마스킬인경우
                            String prevSkill = String.valueOf(skill.charAt(j - 1));
                            if (skillTree.contains(prevSkill)) { //필수선마해야할 스킬 배움
                                prevSkillIndex = skillTree.indexOf(skill2); // 배운 필수선마스킬 인덱스 set
                            } else { // 이전 선마 스킬 안배움
                                break;
                            }
                        } else { // 첫번째 필수스킬인 경우
                            prevSkillIndex = skillTree.indexOf(skill2);
                        }
                    } else {
                        break;
                    }
                }
                //마지막 스킬 검사인 경우 (모든 경우의 수 합격했으니 답 +1)
                if (j == skill.length() - 1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}