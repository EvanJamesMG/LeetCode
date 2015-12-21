/*
 N-Queens ����ı��Σ�ֻ��ͳ�ƽ�������࣬������Ӽ���
*/
public class Solution 
{
    private int res=0;
    public int totalNQueens(int n) 
    {  
        int[] loc = new int[n];  //��¼�ʺ�����һ�У�������
        dfs(loc,0,n);  
        return res;  
    }  
    public void dfs(int[] loc, int cur, int n)
    {  
        if(cur==n)   
            res++;  
        else
        {  
            for(int i=0;i<n;i++)
            {  
                loc[cur] = i;  
                if(isValid(loc,cur))  
                    dfs(loc,cur+1,n); 
            }  
        }  
    }  
    public boolean isValid(int[] loc, int cur)
    {  
        for(int i=0;i<cur;i++)//ֻ��Ҫ��֤����Щ�Ѿ���λ�Ļʺ󲻳�ͻ����  
        {  
            if(loc[i]==loc[cur]||Math.abs(loc[i]-loc[cur])==(cur-i)) //��֤�Խ��ߣ����ݶԽ������ʣ��� �� �� 
                                                                     //��ô���ǲ���д�� Math.abs(loc[i] - loc[cur]) == (cur - i) 
                return false;  
        }  
        return true;  
    }  

}