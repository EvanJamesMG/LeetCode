/*
Repeated DNA Sequences

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return: ["AAAAACCCCC", "CCCCCAAAAA"].
��ϣ��

���Ӷ�

ʱ�� O(N) �ռ� O(N)

˼·

��򵥵����������ǿ��԰�λ��һλ��ÿ���Ӵ��������ϣ���У������ϣ�����Ѿ�������Ӵ��������ǵ�һ���ظ�����������С�����Ѿ�������Σ��򲻼������С������ϣ��û������Ӵ����������Ӵ������ϣ���С�

*/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int index = 10; index <= s.length(); index++){
            // �ӵ�10λ��ʼ��Ϊ��β��λ��һλ���Ƚ�һ���Ӵ�
            String substr = s.substring(index - 10, index);
            if(map.containsKey(substr)){
                // ����ǵ�һ���������������
                if(map.get(substr) == 1){
                    res.add(substr);
                }
                // ���Ϊ�Ѿ�������һ����
                map.put(substr, 2);
            } else {
                // ��������ڣ���������
                map.put(substr, 1);
            }
        }
        return res;
    }
}