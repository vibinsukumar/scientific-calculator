package com.vibin.calc;

import java.util.*;

/**
 * 
 * @author Vibin Sukumar
 * @School Cambridge Public School, Bangalore
 * @Std 10th
 * @Date Oct 2019
 * Usage: just run and provide expression
 */
public class ScientificCalculator
{

	public void handleNegative(ArrayList<String> inp1)
	{
		for (int i = 0; i < inp1.size(); i++)// negative number

		{

			String N = inp1.get(i);
			if (i == 0)
			{
				if ((((i + 1) <= inp1.size() - 1) && ((i + 2) <= inp1.size() - 1)) && N.equals("-")
						&& ((inp1.get(i + 1).charAt(0) >= 48 && inp1.get(i + 1).charAt(0) <= 57)
								|| inp1.get(i + 1).charAt(0) == 46)
						&& inp1.get(i + 2).equals("("))
				{
					String num = inp1.get(i + 1);
					inp1.set(0, "-".concat(num));
					inp1.set(1, "*");
				} else if ((((i + 1) <= inp1.size() - 1) && ((i + 2) <= inp1.size() - 1)) && N.equals("-")
						&& ((inp1.get(i + 1).charAt(0) >= 48 && inp1.get(i + 1).charAt(0) <= 57)
								|| inp1.get(i + 1).charAt(0) == 46)
						&& (inp1.get(i + 2).equals("sin") || inp1.get(i + 2).equals("cos")
								|| inp1.get(i + 2).equals("tan") || inp1.get(i + 2).equals("log")))
				{
					inp1.set(0, "-".concat(inp1.get(i + 1)));
					inp1.set(1, "*");
				} else if (N.equals("-")
						&& ((inp1.get(i + 1).charAt(0) >= 48 && inp1.get(i + 1).charAt(0) <= 57)
								|| inp1.get(i + 1).charAt(0) == 46))
				{
					inp1.set(0, "-".concat(inp1.get(i + 1)));
					inp1.remove(1);
				} else if (((i + 1) <= inp1.size() - 1) && N.equals("-") && inp1.get(i + 1).equals("(")) // -(sin30)
				{
					inp1.set(0, "-1");
					inp1.add(1, "*");
				}

				else if ((((i + 1) <= inp1.size() - 1) && ((i + 2) <= inp1.size() - 1)
						&& ((i + 3) <= inp1.size() - 1))
						&& N.equals("-")
						&& ((inp1.get(i + 1).charAt(0) >= 48 && inp1.get(i + 1).charAt(0) <= 57)
								|| inp1.get(i + 1).charAt(0) == 46)
						&& inp1.get(i + 2).equals("*") && inp1.get(i + 3).equals("("))
				{
					String num = inp1.get(i + 1);
					inp1.set(0, "-".concat(num));
					inp1.remove(1);
				}

			} else if (((i + 1) <= inp1.size() - 1) && ((i + 2) <= inp1.size() - 1))
			{
				if (N.equals("(") && inp1.get(i + 1).equals("-")
						&& ((inp1.get(i + 2).charAt(0) >= 48 && inp1.get(i + 2).charAt(0) <= 57)
								|| inp1.get(i + 2).charAt(0) == 46))
				{
					inp1.set(i + 1, (inp1.get(i + 1) + inp1.get(i + 2)));
					inp1.remove(i + 2);
				}

				else if (N.equals("^") && inp1.get(i + 1).equals("-")
						&& ((inp1.get(i + 2).charAt(0) >= 48 && inp1.get(i + 2).charAt(0) <= 57)
								|| inp1.get(i + 2).charAt(0) == 46))
				{
					inp1.set(i + 1, "-".concat(inp1.get(i + 2)));
					inp1.remove(i + 2);
				} else if (N.equals("/") && inp1.get(i + 1).equals("-")
						&& ((inp1.get(i + 2).charAt(0) >= 48 && inp1.get(i + 2).charAt(0) <= 57)
								|| inp1.get(i + 2).charAt(0) == 46))
				{
					inp1.set(i + 1, "-".concat(inp1.get(i + 2)));
					inp1.remove(i + 2);

				} else if (N.equals("*") && inp1.get(i + 1).equals("-")
						&& ((inp1.get(i + 2).charAt(0) >= 48 && inp1.get(i + 2).charAt(0) <= 57)
								|| inp1.get(i + 2).charAt(0) == 46))
				{
					inp1.set(i + 1, "-".concat(inp1.get(i + 2)));
					inp1.remove(i + 2);
				}

			}
			if (((i + 1) <= inp1.size() - 1) && ((i + 2) <= inp1.size() - 1)
					&& (N.equals("sin") || N.equals("cos") || N.equals("tan") || N.equals("log"))
					&& inp1.get(i + 1).equals("-")
					&& ((inp1.get(i + 2).charAt(0) >= 48 && inp1.get(i + 2).charAt(0) <= 57)
							|| inp1.get(i + 2).charAt(0) == 46))
			{

				inp1.set(i + 1, "-".concat(inp1.get(i + 2)));
				inp1.remove(i + 2);

			}

		}
	}

	public void insertMult(ArrayList<String> inp1)
	{
		for (int i = 0; i < inp1.size() - 1; i++)// to insert multiplication symbol
		{
			if ((i + 1) <= inp1.size() - 1)
			{
				if (((inp1.get(i).charAt(0) >= 48 && inp1.get(i).charAt(0) <= 57)
						|| inp1.get(i).charAt(0) == 46) && (inp1.get(i + 1).equals("(")))// to insert between
																							// number and (
				{

					inp1.add(i + 1, "*");

				} else if ((inp1.get(i).equals(")"))
						&& ((inp1.get(i + 1).charAt(0) >= 48 && inp1.get(i + 1).charAt(0) <= 57)
								|| inp1.get(i + 1).charAt(0) == 46))// to insert between ) and number
				{
					inp1.add(i + 1, "*");
				} else if (((inp1.get(i).charAt(0) >= 48 && inp1.get(i).charAt(0) <= 57)
						|| inp1.get(i).charAt(0) == 46)
						&& (inp1.get(i + 1).equals("sin") || inp1.get(i + 1).equals("cos")
								|| inp1.get(i + 1).equals("tan") || inp1.get(i + 1).equals("log"))) // to
																									// insert
																									// between
																									// number
																									// and sin
				{
					inp1.add(i + 1, "*");
				} else if (inp1.get(i).equals(")") && inp1.get(i + 1).equals("("))// insert between ) and (
				{
					inp1.add(i + 1, "*");

				} else if (inp1.get(i).equals(")")
						&& (inp1.get(i + 1).equals("sin") || inp1.get(i + 1).equals("cos")
								|| inp1.get(i + 1).equals("tan") || inp1.get(i + 1).equals("log")))
				{
					inp1.add(i + 1, "*");
				}

			}

		}
		String back[] =
		{ "!", "%", ")", "π", "", "", "" };
		String front[] =
		{ "sin", "cos", "tan", "log", "√", "(", "π" };

		for (int i = 0; i < inp1.size(); i++)
		{
			String pi = inp1.get(i);
			int a = 0;
			if (pi.equals("π"))
			{
				first: for (int j = 0; j < front.length; j++)
				{
					if ((i - 1 >= 0) && ((back[j].equals(inp1.get(i - 1)))
							|| ((inp1.get(i - 1).charAt(0) >= 48 && inp1.get(i - 1).charAt(0) <= 57)
									|| inp1.get(i - 1).charAt(0) == 46)))
					{
						a++;
						inp1.add(i, "*");

					}

					if ((i + 1 < inp1.size()) && (front[j].equals(inp1.get(i + 1))
							|| ((inp1.get(i + 1).charAt(0) >= 48 && inp1.get(i + 1).charAt(0) <= 57)
									|| inp1.get(i + 1).charAt(0) == 46)))
					{
						a++;
						inp1.add(i + 1, "*");
					}
					if (a > 0)
					{
						break first;
					}
				}
			}
		}
		if (inp1.get(0).equals("-") && inp1.get(1).equals("π"))
		{
			inp1.set(0, "-π");
			inp1.remove(1);
		}

	}

	public void addBracket(ArrayList<String> inp1)// add ) at last if needed
	{
		int nobta = 0;
		for (int i = 0; i < inp1.size(); i++)
		{
			String b = inp1.get(i);
			if (b.equals("("))
			{
				nobta++;
			} else if (b.equals(")"))
			{
				nobta--;
			}
		}
		if (nobta > 0)
		{
			for (int i = 1; i <= nobta; i++)
			{
				inp1.add(")");
			}
		} else if (nobta < 0)
		{
			System.out.println(
					" x!  ^  %      / * \n sin cos tan  7 8 9 - \n  π  log  √   4 5 6 + \n              1 2 3 ( ) \n                0 . ");
			System.out.println("invalid input\n");

			inp1.clear();
		}
	}

	public String factorial(String fac)// to calc factorial of number
	{
		int d = 0;
		for (int i = 0; i < fac.length(); i++)// to check if number is integer or decimal
		{
			char ch = fac.charAt(i);
			if (ch == '.')
			{
				d++;
				break;
			}
		}
		double d1 = Double.parseDouble(fac);
		if (d == 1)
		{

			double fact = Math.pow((d1 / 2.7182818285), d1) * Math.sqrt(Math.PI * ((2 * d1) + (1 / 3)));
			return Double.toString(fact);
		} else
		{
			double fa = 1;
			for (int i = 1; i <= d1; i++)
			{
				fa = fa * i;
			}
			return Double.toString(fa);
		}

	}

	public void calc(ArrayList<String> inp2, int s1, int l1)// s1=starting index l1=lastindex 1.! 2.% 3.π 4.√
															// 5.sin 6.cos 7.tan 8.log 9.^ 10./ 11.* 12.+ 13.-
	{

		for (int j = 1; j <= 13; j++)
		{
			for (int i = s1; i < l1; i++)
			{
				String gi = inp2.get(i);
				if (j == 1 && gi.equals("π"))
				{
					inp2.set(i, Double.toString(Math.PI));

				} else if (j == 2 && gi.equals("!"))
				{
					if (Double.parseDouble(inp2.get(i - 1)) >= 0.0)
							
					{
						String f = factorial(inp2.get(i - 1));

						inp2.set(i - 1, f);
						inp2.remove(i);
						l1--;
					} else if (Double.parseDouble(inp2.get(i - 1)) < 0.0)
					{
						System.out.println(
								" x!  ^  %      / * \n sin cos tan  7 8 9 - \n  π  log  √   4 5 6 + \n              1 2 3 ( ) \n                0 . ");

						System.out.println("invalid input\n");
						inp2.clear();
						l1 = 0;
					} else if (Double.parseDouble(inp2.get(i - 1)) >= 17.0)
					{
						System.out.println(
								" x!  ^  %      / * \n sin cos tan  7 8 9 - \n  π  log  √   4 5 6 + \n              1 2 3 ( ) \n                0 . ");

						System.out.println(Double.parseDouble(inp2.get(i - 1)) + "!" + "not supported");
						inp2.clear();
						l1 = 0;
					}

				} else if (j == 3 && gi.equals("%"))
				{
					double p = Double.parseDouble(inp2.get(i - 1));
					p = p / 100.0;
					inp2.set(i - 1, Double.toString(p));
					inp2.remove(i);
					l1--;
				}

				else if (j == 4 && gi.equals("√"))
				{
					double s = Math.sqrt(Double.parseDouble(inp2.get(i + 1)));
					inp2.set(i, Double.toString(s));
					inp2.remove(i + 1);
					l1--;
				} else if (j == 5 && gi.equals("sin"))
				{
					double si = Math.sin(Math.toRadians(Double.parseDouble(inp2.get(i + 1))));
					inp2.set(i, Double.toString(si));
					inp2.remove(i + 1);
					l1--;

				} else if (j == 6 && gi.equals("cos"))
				{
					double si = Math.cos(Math.toRadians(Double.parseDouble(inp2.get(i + 1))));
					inp2.set(i, Double.toString(si));
					inp2.remove(i + 1);
					l1--;

				} else if (j == 7 && gi.equals("tan"))
				{
					double si = Math.tan(Math.toRadians(Double.parseDouble(inp2.get(i + 1))));
					inp2.set(i, Double.toString(si));
					inp2.remove(i + 1);
					l1--;

				} else if (j == 8 && gi.equals("log"))
				{
					double si = Math.log10(Double.parseDouble(inp2.get(i + 1)));
					inp2.set(i, Double.toString(si));
					inp2.remove(i + 1);
					l1--;

				} else if (j == 9 && gi.equals("^"))
				{
					double fir = Double.parseDouble(inp2.get(i - 1));
					double sec = Double.parseDouble(inp2.get(i + 1));
					double pow = Math.pow(fir, sec);
					inp2.set(i - 1, Double.toString(pow));
					inp2.remove(i);
					inp2.remove(i);
					l1 = l1 - 2;
					i--;

				} else if (j == 10 && gi.equals("/"))
				{
					double fir = Double.parseDouble(inp2.get(i - 1));
					double sec = Double.parseDouble(inp2.get(i + 1));
					double d = fir / sec;
					inp2.set(i - 1, Double.toString(d));
					inp2.remove(i);
					inp2.remove(i);
					i--;
					l1 = l1 - 2;

				} else if (j == 11 && gi.equals("*"))
				{
					double fir = Double.parseDouble(inp2.get(i - 1));
					double sec = Double.parseDouble(inp2.get(i + 1));
					double d = fir * sec;
					inp2.set(i - 1, Double.toString(d));
					inp2.remove(i);
					inp2.remove(i);
					i--;
					l1 = l1 - 2;

				} else if (j == 12 && gi.equals("-"))
				{
					double fir = Double.parseDouble(inp2.get(i - 1));
					double sec = Double.parseDouble(inp2.get(i + 1));
					double d = fir - sec;
					inp2.set(i - 1, Double.toString(d));
					inp2.remove(i);
					inp2.remove(i);
					i--;
					l1 = l1 - 2;

				} else if (j == 13 && gi.equals("+"))
				{
					double fir = Double.parseDouble(inp2.get(i - 1));
					double sec = Double.parseDouble(inp2.get(i + 1));
					double d = fir + sec;
					inp2.set(i - 1, Double.toString(d));
					inp2.remove(i);
					inp2.remove(i);
					i--;
					l1 = l1 - 2;

				}

			}
		}
		if (s1 > 0)
		{
			inp2.remove(l1);
			inp2.remove(s1 - 1);
		}

	}

	public boolean isBracket(ArrayList<String> inp3)// check bracket
	{
		int b = 0;
		for (int i = 0; i < inp3.size(); i++)
		{
			if (inp3.get(i).equals("("))
			{
				b++;
				break;
			}
		}
		if (b == 1)
			return true;
		else
			return false;
	}

	public void evB(ArrayList<String> inp4)// evlB
	{
		while (isBracket(inp4))
		{
			int S = 0;
			int L = inp4.size();
			second: for (int i = 0; i < inp4.size(); i++)
			{
				if (inp4.get(i).equals("("))
				{
					S = i + 1;
				} else if (inp4.get(i).equals(")"))
				{
					L = i;
					calc(inp4, S, L);
					break second;

				}
			}

		}
	}

	public static void main(String args[])
	{

		System.out.println(
				" x!  ^  %      / * \n sin cos tan  7 8 9 - \n  π  log  √   4 5 6 + \n              1 2 3 ( ) \n                0 . \n");
		System.out.println("\nenter his to check history\n enter quit to exit calculator\n");

		Scanner sc = new Scanner(System.in);
		ArrayList<String> inp1 = new ArrayList<String>();
		ArrayList<String> his = new ArrayList<String>();

		ScientificCalculator ob = new ScientificCalculator();

		restartCalc: while (true)
		{
			System.out.println("\n enter expression to be calculated");
			String inp = sc.nextLine();
			System.out.println("\f");

			if (inp.equals("quit"))
			{
				System.out.println("\n\n");
				System.out.println("exited");
				sc.close();
				System.exit(0);
			}

			else if (inp.equals("his"))
			{
				if (his.isEmpty())
				{
					System.out.println("no history\n");
				} else
				{
					System.out.println("history\n");
					for (int i = 0; i < his.size(); i++)
					{
						System.out.println((i + 1) + ". " + his.get(i));
					}
				}
				System.out.println(
						"\n x!  ^  %      / * \n sin cos tan  7 8 9 - \n  π  log  √   4 5 6 + \n              1 2 3 ( ) \n                0 . \n\n");

				continue restartCalc;
			}

			String c = "";
			String n = "";
			for (int i = 0; i < inp.length(); i++)// to seprate expression
			{
				char ch = inp.charAt(i);

				if ((ch >= 48 && ch <= 57) || ch == 46)
				{
					if (!(c.isEmpty()))
					{
						inp1.add(c);
						c = "";
					}
					n += ch;
				} else// to store sin cos tan log and operators
				{
					if (!(n.isEmpty()))
					{
						inp1.add(n);
						n = "";
					}

					if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '('
							|| ch == ')' || ch == '^' || ch == '%' || ch == '!' || ch == 'π' || ch == '√')
					{
						if (!(c.isEmpty()))
						{
							inp1.add(c);
							c = "";
						}
						inp1.add(Character.toString(ch));
					}

					else if ((ch == 'a' || ch == 'c' || ch == 'g' || ch == 'i' || ch == 'l' || ch == 'n'
							|| ch == 'o' || ch == 's' || ch == 't'))// a,c,g,i,l,n,o,s,t
					{
						c = c + ch;
					}

					else
					{
						System.out.println(
								" x!  ^  %      / * \n sin cos tan  7 8 9 - \n  π  log  √   4 5 6 + \n              1 2 3 ( ) \n                0 . ");
						System.out.println("invalid input\n");

						inp1.clear();
						continue restartCalc;
					}

				}

			}
			if (!(n.isEmpty()))
			{
				inp1.add(n);
			} else if (!(c.isEmpty()))
			{
				inp1.add(c);
			}

			ob.handleNegative(inp1);

			ob.insertMult(inp1);

			ob.addBracket(inp1);

			if (ob.isBracket(inp1))
			{
				ob.evB(inp1);
				int s = 0;
				int l = inp1.size();
				ob.calc(inp1, s, l);
			}

			else
			{
				int s = 0;
				int l = inp1.size();

				ob.calc(inp1, s, l);
			}

			if (!inp1.isEmpty())
			{
				System.out.println(
						" x!  ^  %      / * \n sin cos tan  7 8 9 - \n  π  log  √   4 5 6 + \n              1 2 3 ( ) \n                0 . ");

				System.out.println("\n               " + inp);
				System.out.println("\n             = " + inp1.get(0) + "\n");
				his.add(inp.concat(" = ".concat(inp1.get(0))));
			}
			inp1.clear();
		}

	}
}
