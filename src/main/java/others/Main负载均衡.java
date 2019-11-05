package others;


import java.util.Scanner;

public class Main负载均衡 {
    public static void main(String[] args) {

        /*
        思路
        本题的本质是手写一个负载均衡
        首先分析五种命令:
        1:服务器的名称 -> 这个服务器部署在了哪个节点
        2:token -> token应分发到那个服务器
        3:宕机的服务器+token -> token应分发到那个服务器 (和2的区别就在于要排除传来的宕机的服务器才行)
        4:要增加的服务器的名称 -> 新增服务器部署在了哪个节点
        5:增加的服务器+token -> 新增服务器和token分发同时进行

        问题的关键就在于这个hash如何写
        为了保证在插入新服务器的同时不影响就服务器,插入顺序应如下
        01 -> 25 02 -> 525
        03 -> 75 04 -> 575
        05 -> 125 06 -> 625
        07 -> 175 08 -> 675
        09 -> 225 10 -> 725
        11 -> 275 12 -> 775
        13 -> 325 14 -> 825
        15 -> 375 16 -> 875
        17 -> 425 18 -> 925
        19 -> 475 20 -> 975

        比如126 - 25 = 101
        101 / 50 = 2
        2+1 = 3;
        3 * 50 + 25 = 175

        124-25 = 99
        99/50 = 1
        1+1 = 2
        2*50 + 25 = 125

        抽象一下
        奇数是n*25
        偶数是(n-1)*25+500

        token的哈希函数已经给出

        要维护一个已经添加的队列以供token轮询
         */

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(handleRequest(sc.next()));
        }

    }

    private static int handleRequest(String request) {
        request = request.substring(2);
        if (request.charAt(0) == '1') {
            return hashServer(request);
        }else if (request.charAt(0) == '2'){
            return getTokenLocation(request);
        }else if (request.charAt(0) == '3'){

        }else if (request.charAt(0) == '4'){
            return hashServer(request);
        }else if (request.charAt(0) == '5'){

        }
        return 0;
    }

    private static int getTokenLocation(String s) {
        int index = hashToken(s);
        return ((index - 25) / 50 + 1) * 50 + 25;
    }

    private static int hashToken(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res += (int)c;
        }
        return res % 999;
    }

    private static int hashServer(String s) {
        int n = parseServer(s);
        return n % 2 == 1 ? n*25 : (n-1)*25+500;
    }

    private static int parseServer(String s) {
        String substring = s.substring(s.length() - 2, s.length());
        return Integer.parseInt(substring);
    }

}