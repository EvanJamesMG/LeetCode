/*
���ǰ���һ��ֳɼ���С����

1. ��ͳ��dfs�ݹ�

2. ��֤����Queen�ĵط��Ƿ�Ϸ�

3. ���Board���

��ô���ĺô����ǣ�һ��ʼ�����ǲ��ý���һ���Ӵ��Board������ѡ��һ�������ӦBoard�����ÿһ�У�����ÿһ��ֵ��Ӧ��һ�з���Queen���к�

���磺 int[ ] {3,1,4,2} ������õĵص�ֱ�Ϊ[1,3], [2,1], [3,4], [4,2] ��ôһ���������úܼ򵥵��������ʾ������Board��

������isValid�������жϵ�ʱ���ǳ���࣬���Ұ����Board���������˳���


dfs��ѭ����ָ��һ����ӵ�һ�е����һ�з��õ����п��ܣ�������õĵص�ͨ��isValid��֤��ͨ��cur+1������һ�н��еݹ飬���ûͨ����֤������һ��λ�ã��������λ�ö���Valid��������һ��

����int[ ]�ĺô��ǣ�ÿһ������ֻ��ı�һ�����־��൱�ڸı������ӵķ���λ��

isValid����������int[ ]�����У������ͱ�����ÿһ�г����ظ���Queen ����Ϊ�㲻������һ��int�����2��ֵ������������֤ ����������ֻ����֤�кͶԽ���

��֤�е�ʱ��Ҫ��֤��һ��֮ǰ������û���ظ��ģ�ע������֤֮ǰ��ร�

��֤�Խ��ߣ����ݶԽ������ʣ��� �� �� ��ô���ǲ���д�� Math.abs(loc[i] - loc[cur]) == (cur - i) 

���loc�ۣ������¼���ǽ����Ϣ������н⣩���ǰ���ת����String, ���Board����
*/

public class Solution 
{
	public ArrayList<String[]> solveNQueens(int n) 
    {  
        ArrayList<String[]> res = new ArrayList<String[]>();  
        int[] loc = new int[n];  //��¼�ʺ�����һ�У�������
        dfs(res,loc,0,n);  
        return res;  
    }  
    public void dfs(ArrayList<String[]> res, int[] loc, int cur, int n)
    {  
        if(cur==n)   
            printboard(res,loc,n);  
        else
        {  
            for(int i=0;i<n;i++)
            {  
                loc[cur] = i;  
                if(isValid(loc,cur))  
                    dfs(res,loc,cur+1,n);  
            }  
        }  
    }  
    public boolean isValid(int[] loc, int cur)
    {  
        for(int i=0;i<cur;i++)//ֻ��Ҫ��֤����Щ�Ѿ���λ�Ļʺ󲻳�ͻ����  
        {  
            if(loc[i]==loc[cur]||Math.abs(loc[i]-loc[cur])==(cur-i)) //��֤�Խ��ߣ����ݶԽ������ʣ��� �� �� 
                       return false;                                 // ��ô���ǲ���д�� Math.abs(loc[i] - loc[cur]) == (cur - i) 
        }  
        return true;  
    }  
    public void printboard(ArrayList<String[]> res, int[] loc, int n)
    {  
        String[] ans = new String[n];  
        for(int i=0;i<n;i++)
        {  
            String row = new String();  
            for(int j=0;j<n;j++)
            {  
                if(j==loc[i]) row += "Q";  
                else row += ".";  
            }  
            ans[i] = row;  
        }  
        res.add(ans);  
    }  
}