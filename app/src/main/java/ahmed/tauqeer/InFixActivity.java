package ahmed.tauqeer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InFixActivity extends AppCompatActivity implements View.OnClickListener {

    //Creating Everything
    AlphaAnimation alpha = new AlphaAnimation(1F,0.8F);
    EditText infix,postfix,prefix;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_fix);

        //Initializing Components
        infix = (EditText) findViewById(R.id.infix);
        postfix = (EditText) findViewById(R.id.postfix);
        prefix = (EditText) findViewById(R.id.prefix);
        convert = (Button) findViewById(R.id.convert6);

        //OnClick Listeners
        convert.setOnClickListener(this);
    }

    static String infixToPostfix(String exp)
    {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        ArrayStack stack = new ArrayStack(30);

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
            else
            {
                while (!stack.isEmpty() && precedence(c) <= precedence((char)stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty())
            result += stack.pop();

        return result;
    }

    static int precedence(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(alpha);
        if (v.getId() == R.id.convert6) {
            String expression = infix.getText().toString();
            if (expression.equals("")) Toast.makeText(InFixActivity.this,"Enter an expression first!",Toast.LENGTH_LONG).show();
            else {
                String result = infixToPostfix(expression);
                String result2 = infixToPrefix(expression);
                postfix.setText(result);
                prefix.setText(result2);
            }
        }
    }

    static boolean isOperator(char c)
    {
        return (!(c >= 'a' && c <= 'z') &&
                !(c >= '0' && c <= '9') &&
                !(c >= 'A' && c <= 'Z'));
    }

    // Function to find priority
// of given operator.
    static int getPriority(char C)
    {
        if (C == '-' || C == '+')
            return 1;
        else if (C == '*' || C == '/')
            return 2;
        else if (C == '^')
            return 3;
        return 0;
    }

    // Function that converts infix
// expression to prefix expression.
    static String infixToPrefix(String infix)
    {
        // stack for operators.
        ArrayStack operators = new ArrayStack(20);

        // stack for operands.
        ArrayStack operands = new ArrayStack(20);

        for (int i = 0; i < infix.length(); i++)
        {

            // If current character is an
            // opening bracket, then
            // push into the operators stack.
            if (infix.charAt(i) == '(')
            {
                operators.push(infix.charAt(i));
            }

            // If current character is a
            // closing bracket, then pop from
            // both stacks and push result
            // in operands stack until
            // matching opening bracket is
            // not found.
            else if (infix.charAt(i) == ')')
            {
                while (!operators.isEmpty() &&
                        (char)operators.peek() != '(')
                {

                    // operand 1
                    String op1 = (String) operands.peek();
                    operands.pop();

                    // operand 2
                    String op2 = (String) operands.peek();
                    operands.pop();

                    // operator
                    char op = (char) operators.peek();
                    operators.pop();

                    // Add operands and operator
                    // in form operator +
                    // operand1 + operand2.
                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }

                // Pop opening bracket
                // from stack.
                operators.pop();
            }

            // If current character is an
            // operand then push it into
            // operands stack.
            else if (!isOperator(infix.charAt(i)))
            {
                operands.push(infix.charAt(i) + "");
            }

            // If current character is an
            // operator, then push it into
            // operators stack after popping
            // high priority operators from
            // operators stack and pushing
            // result in operands stack.
            else
            {
                while (!operators.isEmpty() &&
                        getPriority(infix.charAt(i)) <=
                                getPriority((char)operators.peek()))
                {

                    String op1 = (String)operands.peek();
                    operands.pop();

                    String op2 = (String) operands.peek();
                    operands.pop();

                    char op = (char) operators.peek();
                    operators.pop();

                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }

                operators.push(infix.charAt(i));
            }
        }

        // Pop operators from operators
        // stack until it is empty and
        // operation in add result of
        // each pop operands stack.
        while (!operators.isEmpty())
        {
            String op1 = (String) operands.peek();
            operands.pop();

            String op2 = (String) operands.peek();
            operands.pop();

            char op = (char) operators.peek();
            operators.pop();

            String tmp = op + op2 + op1;
            operands.push(tmp);
        }

        // Final prefix expression is
        // present in operands stack.
        return (String) operands.peek();
    }

}
