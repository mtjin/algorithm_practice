class Solution {
    public int solution(String gameSkillTree, String[] skill_trees) { //선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees
        int answer = 0;
        int prevGameSkillIndex = -1;
        for (int i = 0; i < skill_trees.length; i++) { //유저스킬트리 반복
            prevGameSkillIndex = -1; // 배운 게임스킬트리 스킬 인덱스
            String userSkillTree = skill_trees[i]; //유저 스킬트리
            for (int j = 0; j < gameSkillTree.length(); j++) { // 게임 스킬트리의 스킬 하나씩 반복 (게임 스킬을 유저 스킬트리와 비교)
                String gameSkill = String.valueOf(gameSkillTree.charAt(j));
                if (userSkillTree.contains(gameSkill)) { // 유저 스킬트리에 게임 스킬이 있는 경우
                    if (userSkillTree.indexOf(gameSkill) > prevGameSkillIndex) { // 유저스킬트리에 게임스킬 인덱스가 이전 게임스킬트리 인덱스보다 뒤에있는거야함
                        if (j > 0) { // 두번째 이상의 게임스킬인 경우
                            String prevSkill = String.valueOf(gameSkillTree.charAt(j - 1)); // 이전에 배운 게임스킬
                            if (userSkillTree.contains(prevSkill)) { // 이전 스킬을 유저가 배웠는지 배웠다면 유저스킬트리의 해당 게임스킬 위치를 저장 (이전에 배운 prevGameSkillIndex 보다 클거임)
                                prevGameSkillIndex = userSkillTree.indexOf(gameSkill);
                            } else { // 이전스킬 안배웠으면 잘못된거임 break
                                break;
                            }
                        } else { //첫번째 게임 스킬인 경우 유저스킬트리의 해당 게임스킬 위치를 저장
                            prevGameSkillIndex = userSkillTree.indexOf(gameSkill);
                        }
                    } else {
                        break;
                    }
                }
                //마지막 스킬 검사인 경우
                if (j == gameSkillTree.length() - 1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}