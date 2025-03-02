// See https://aka.ms/new-console-template for more information
class Program
{

    static void Main(string[] args)
    {
        int age = 10;
        const double val = 3.037689;

        //positional formating
        Console.WriteLine(string.Format("${0:0.0} {1}", val, 100)); //upto 1 decimal place
        Console.WriteLine(string.Format("${0:0.00}", val)); //upto 2 decimal place

        //terenary/conditional operator
        string result = age > 0 ? "Valid" : "Invalid";
        Console.WriteLine(result);
        string sval = Convert.ToString(val);
        Console.WriteLine(sval);

        //TryParse
        Console.WriteLine("enter a number :");
        string input = Console.ReadLine();
        bool success = int.TryParse(input, out int res);//success=true if input is of type int & stores the value of input entered in output variable res which is of type int
                                                        //success=false if input value is not of type int & the output varible res of int type stores 0
        Console.Write(success);
        Console.WriteLine(res);


        //Strings
        //Empty string[""] -contains no context,but has value : string.Empty 
        // string str_null=null//no value,no context :string.IsNullOrEmpty(input) -checks for both null or empty string
        Console.WriteLine("enter a number in rupees:" + input + " rupees");//string formatting
        Console.WriteLine("enter a number in rupees: {0} rupees", input);//string formatting
        Console.WriteLine($"enter a number in rupees: {input} rupees");//string interpolation & concatenation--BEST METHOD
        string test = string.Concat("your input is ", input, " rupee");
        Console.WriteLine(test);
        string[] names = { "ab", "cd" }; //array of strings
        Console.WriteLine(string.Concat(names));
        Console.WriteLine(string.Equals(input, "40"));//Equals : compares only value --ALWAYS USE THIS ; == : compares value & type
        for (int i = 0; i < input.Length; i++)
        {
            Console.WriteLine(input[i]);//each letter of input string is returned of "char" type
            Thread.Sleep(2000);
        }
        Console.WriteLine(input.Contains("j"));
    }
}