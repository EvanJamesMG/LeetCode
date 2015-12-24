/*

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/



/*����ѭ���ݹ��������⡣
��������Ҫ��ȷ��ͳIP ��ַ�Ĺ����Ƿ�4��Part��ÿ��Part�Ǵ�0-255������

0-255�����֣�ת�����ַ�����ÿ��Part ������һ���ַ���ɣ������ַ���ɣ������������ַ���ɡ�

����ÿ����������˵�����3λ����1λ��������ÿһ�����ѭ��3�Σ���������Ρ���ΪIP��ַ���4���ֶΣ���������3��ʱ��˵���Ѿ��������3�����ˣ���ô��ʣ��û������νӵ���β���ɡ�

���������Ҫ��֤����������ǺϷ��ģ����ƴ�ӵ�ʣ�����Ҳ�ǺϷ��ġ�

 ע�⿪ͷ�����0�Ļ�Ҫ���⴦�������ͷ��0���ж��������ǲ���0�����ǵĻ����ַ����ǷǷ��ġ���Ϊ001��01���ǲ��Եġ�
 */
 public ArrayList<String> restoreIpAddresses(String s) {  
        ArrayList<String> res = new ArrayList<String>();  
        String item = new String();
        if (s.length()<4||s.length()>12) //С��4��ÿ�γ���Ϊ�յ����������12��ÿ�γ��ִ���4���ַ�������Ǹ������ǲ������
        return res;  
        
        dfs(s, 0, item, res);  
        return res;  
    }  
      
    public void dfs(String s, int start, String item, ArrayList<String> res){  
        if (start == 3 && isValid(s)) {  //ǰ���ι̶������Ķ�ֻҪ�������������ɼ���
            res.add(item + s);  
            return;  
        }  
        for(int i=0; i<3 && i<s.length()-1; i++){  
            String substr = s.substring(0,i+1);  
            if (isValid(substr))
                dfs(s.substring(i+1, s.length()), start+1, item + substr + '.', res);  
        }  
    }  
      
    public boolean isValid(String s){  
        if (s.charAt(0)=='0')
            return s.equals("0");  
            int num = Integer.parseInt(s);
            
        if(num <= 255 && num > 0)
            return true;
        else
            return false;
    }