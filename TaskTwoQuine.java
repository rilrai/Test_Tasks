/**
 * Created by CuCbKu on 07.07.2015.
 * 
 * A quine is a non-empty computer program
 * which takes no input and produces a copy of its own source code as its only output.
 */
public class TaskTwoQuine {
    public static void main(String[] args)
    {
        char qMark = 34;
        String[] lines = {
                "public class TaskTwoQuine",
                "{",
                "  public static void main(String[] args)",
                "  {",
                "    char qMark = 34;",
                "    String[] lines = {",
                "    ",
                "    };",
                "    for(int i = 0; i < 6; i++)",
                "        System.out.println(lines[i]);",
                "    for(int i = 0; i < lines.length; i++)",
                "        System.out.println(lines[6] + qMark + lines[i] + qMark + ',');",
                "    for(int i = 7; i < lines.length; i++)",
                "        System.out.println(lines[i]);",
                "  }",
                "}",
        };
        for(int i = 0; i < 6; i++)
            System.out.println(lines[i]);
        for(int i = 0; i < lines.length; i++)
            System.out.println(lines[6] + qMark + lines[i] + qMark + ',');
        for(int i = 7; i < lines.length; i++)
            System.out.println(lines[i]);
    }
}
