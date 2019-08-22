package io.github.bael.annotations;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample {


    public String name = "SpELExample ";

    public String getString() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        return message;
    }

    public Integer getInt() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("2 * 4 * 6 / 3");
        return (Integer) exp.getValue();

    }

    public String getVarString() {
        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("name");
        String name = (String) exp.getValue(this);
        System.out.println(name);

        Expression exp2 = parser.parseExpression("name.concat('Hello World').concat('!')");
        String message = exp2.getValue(this, String.class);
        return message;
    }
}
