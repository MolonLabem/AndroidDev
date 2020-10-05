package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, MainFragment()).commit()
        setContentView(R.layout.activity_main)

        button0.setOnClickListener {
            evaluateExpression("0", clear = true)
        }
        button1.setOnClickListener {
            evaluateExpression("1", clear = true)
        }
        button2.setOnClickListener {
            evaluateExpression("2", clear = true)
        }
        button3.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        button4.setOnClickListener {
            evaluateExpression("4", clear = true)
        }
        button5.setOnClickListener {
            evaluateExpression("5", clear = true)
        }
        button6.setOnClickListener {
            evaluateExpression("6", clear = true)
        }
        button7.setOnClickListener {
            evaluateExpression("7", clear = true)
        }
        button8.setOnClickListener {
            evaluateExpression("8", clear = true)
        }
        button9.setOnClickListener {
            evaluateExpression("9", clear = true)
        }


        buttonAdd.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        buttonSubtract.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        buttonMultiply.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        buttonDivide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        buttonDot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        buttonClear.setOnClickListener {
            inputText.text.clear()
            resultText.text = ""
        }

        buttonEqual.setOnClickListener {
            val text = inputText.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                resultText.text = longResult.toString()
            } else {
                resultText.text = result.toString()
            }
        }

        buttonBackspace.setOnClickListener {
            val text = inputText.text.toString()
            if (text.isNotEmpty()) {
                inputText.text.drop(n = 1)
            }

            inputText.text.clear()
        }
    }

    fun evaluateExpression(string: String, clear: Boolean) {
        if (clear) {
            resultText.text = ""
            inputText.append(string)
        } else {
            inputText.append(resultText.text)
            inputText.append(string)
            resultText.text = ""
        }
    }


}
