package ca.yorku.cmg.lob.exchange;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExchangeTest {

	
	Exchange exc = new Exchange();
	String init_balances;
	
	@BeforeEach
	void setUp() throws Exception {

			exc = new Exchange();

	    	
	    	exc.readSecurityListfromFile("src/test/resources/securities.csv"); 
	    	exc.readAccountsListFromFile("src/test/resources/accounts.csv");
	    	exc.readInitialPositionsFromFile("src/test/resources/initial.csv");
	    	this.init_balances = exc.printBalances(true);

	}

	@Test
	void testSubmitOrder() {
    	exc.processOrderFile("src/test/resources/orders.csv");
    	
    	String exp1 = exc.printAskTable(false);
    	String got1 = 
    			"[  3  MSFT   880.77        14       230     23]\n" +
    			"[  7  MSFT   914.54        27      1250    125]\n" +
    			"[  8  GOOG   249.41        23       870     87]\n" +
    			"[  6  GOOG   253.95        19       290     29]\n" +
    			"[  4  GOOG   267.21        21      1090    109]\n" + 
    			"[  3  GOOG   278.70         5       160     16]\n" +
    			"[  7  GOOG   351.53        49       450     45]\n" +
    			"[  2  GOOG   455.82        20       470     47]\n" +
    			"[  4  META  1011.28        26       960     96]\n" +
    			"[  1  META  1061.73        26       500     50]\n" +
    			"[  2  META  1070.07        45       350     35]\n" +
    			"[  5  META  1074.56        20       840     84]\n" +
    			"[  4  NVDA   187.27        36      1230    123]\n" +
    			"[  1  NVDA   200.80        13      1150    115]\n" +
    			"[  8  NVDA   265.12         1       340     34]\n" +
    			"[  2  NVDA   287.82        27      1220    122]\n" +
    			"[  2  AAPL   273.57        14      1040    104]\n" +
    			"[  5  AAPL   458.30        47      1120    112]\n" +
    			"[  6  AAPL   464.60        10       900     90]\n" +
    			"[  8  AAPL   496.14        49       540     54]\n" +
    			"[  7  AAPL   555.54        18       330     33]\n" +
    			"[  7  TSLA   657.61        27      1190    119]\n" +
    			"[  3  TSLA   722.30        38        30      3]\n" +
    			"[  7  AVGO   435.33        18      1110    111]\n" +
    			"[  5  AMZN   335.44         7      1130    113]\n" +
    			"[  3  AMZN   443.67        47       790     79]\n";
    	assertEquals(exp1,got1);

    	String exp2 = exc.printBidTable(false);
    	String got2 =
    			"[  2  MSFT   488.49        13      1080    108]\n" +
    			"[  4  MSFT   476.22        11       990     99]\n" +
    			"[  5  MSFT   420.79        42       570     57]\n" +
    			"[  1  GOOG   228.01        46      1200    120]\n" +
    			"[  3  GOOG   133.20        31       510     51]\n" +
    			"[  7  GOOG   128.20        11       980     98]\n" +
    			"[  4  GOOG   127.35        43       370     37]\n" +
    			"[  8  GOOG    71.85        25        50      5]\n" +
    			"[  3  META   692.55        14       970     97]\n" +
    			"[  4  META   648.55        12       830     83]\n" +
    			"[  8  META   490.03        16       610     61]\n" +
    			"[  7  META   448.90        14       100     10]\n" +
    			"[  6  NVDA   169.33        18       120     12]\n" +
    			"[  7  NVDA   112.39        12       890     89]\n" +
    			"[  5  NVDA    86.45        39       270     27]\n" +
    			"[  3  NVDA    78.70        22       210     21]\n" +
    			"[  2  AAPL   273.17        44      1280    128]\n" +
    			"[  1  AAPL   244.44        36       220     22]\n" +
    			"[  3  AAPL   192.53        25       320     32]\n" +
    			"[  3  AVGO   285.55        34       530     53]\n" +
    			"[  2  AVGO   270.21        14       260     26]\n" +
    			"[  5  AVGO   229.30        28       880     88]\n" +
    			"[  4  AVGO   183.79        28        10      1]\n" +
    			"[  2  TSLA   527.12        47      1260    126]\n" +
    			"[  1  TSLA   281.15        24       690     69]\n" +
    			"[  1  AMZN   279.86        43      1160    116]\n" +
    			"[  2  AMZN   276.86        27       110     11]\n" +
    			"[  8  AMZN   259.95        19       770     77]\n" +
    			"[  7  AMZN   221.60        11      1140    114]\n" +
    			"[  6  AMZN    94.20        37       560     56]\n";
    	assertEquals(exp2,got2);
    	
    	String exp3 = exc.printTradesLog(false);
    	String got3 = 
    			"[       5         2  GOOG        34   281.48        80]\n" +
    			"[       3         2  GOOG         6   278.70       160]\n" +
    			"[       6         1  MSFT        23   665.95       180]\n" +
    			"[       7         4  NVDA        11   113.68       190]\n" +
    			"[       4         1  AVGO        10   186.06       250]\n" +
    			"[       2         4  TSLA        27   527.13       410]\n" +
    			"[       2         6  TSLA         6   527.13       410]\n" +
    			"[       2         8  MSFT        22   488.49       440]\n" +
    			"[       6         5  GOOG        26   253.95       460]\n" +
    			"[       5         8  MSFT        16   425.86       520]\n" +
    			"[       5         6  MSFT        25   425.86       520]\n" +
    			"[       4         3  TSLA        12   669.63       550]\n" +
    			"[       6         1  NVDA        34   169.38       580]\n" +
    			"[       2         4  AMZN        13   277.85       590]\n" +
    			"[       8         4  AMZN        17   283.60       590]\n" +
    			"[       6         3  TSLA        13   553.72       630]\n" +
    			"[       6         8  TSLA        18   553.72       630]\n" +
    			"[       4         5  AAPL        36   283.66       640]\n" +
    			"[       4         7  AAPL         3   283.66       650]\n" +
    			"[       3         7  AAPL        31   361.50       650]\n" +
    			"[       1         6  GOOG        16   228.01       660]\n" +
    			"[       5         8  TSLA        32   508.21       670]\n" +
    			"[       5         6  TSLA         9   508.21       670]\n" +
    			"[       6         3  MSFT         5   665.95       710]\n" +
    			"[       8         3  MSFT        31   642.54       720]\n" +
    			"[       6         2  NVDA         3   169.38       730]\n" +
    			"[       8         2  NVDA        47   265.12       730]\n" +
    			"[       5         6  NVDA        32    90.44       740]\n" +
    			"[       6         3  AMZN        18   303.42       750]\n" +
    			"[       3         6  AAPL         8   361.50       760]\n" +
    			"[       1         6  AAPL        17   263.94       780]\n" +
    			"[       1         4  AAPL         4   263.94       780]\n" +
    			"[       1         7  AVGO        24   414.07       800]\n" +
    			"[       4         3  MSFT        11   476.85       860]\n" +
    			"[       4         6  MSFT         9   476.85       860]\n" +
    			"[       6         7  AVGO        11   350.71       910]\n" +
    			"[       8         7  AVGO        14   333.70       920]\n" +
    			"[       8         1  AVGO        14   333.70       920]\n" +
    			"[       8         2  META        24   671.16       930]\n" +
    			"[       3         2  META        14   693.55       930]\n" +
    			"[       1         5  TSLA        21   281.15       940]\n" +
    			"[       1         1  TSLA         4   281.15       940]\n" +
    			"[       6         8  AAPL        27   464.60      1000]\n" +
    			"[       1         4  AMZN        12   279.87      1010]\n" +
    			"[       3         1  AVGO         3   292.86      1020]\n" +
    			"[       3         8  AVGO        23   292.86      1020]\n" +
    			"[       5         7  TSLA         7   508.21      1030]\n" +
    			"[       8         7  TSLA        20   646.84      1030]\n" +
    			"[       2         4  AAPL         7   273.57      1040]\n" +
    			"[       3         8  NVDA        31   212.34      1060]\n" +
    			"[       5         8  AVGO        23   229.30      1070]\n" +
    			"[       5         6  AVGO        11   229.30      1070]\n" +
    			"[       4         2  MSFT         9   476.85      1080]\n" +
    			"[       3         6  META        15   693.55      1100]\n" +
    			"[       7         6  META        29   712.47      1100]\n" +
    			"[       1         8  NVDA        19   200.80      1150]\n" +
    			"[       1         7  MSFT        21   745.05      1170]\n" +
    			"[       3         7  MSFT        18   880.77      1170]\n" +
    			"[       7         1  META         2   712.47      1180]\n" +
    			"[       6         1  META        22   776.36      1180]\n" +
    			"[       4         1  META         3  1011.28      1180]\n" +
    			"[       7         7  TSLA        18   657.61      1190]\n" +
    			"[       1         1  GOOG         2   228.01      1200]\n" +
    			"[       1         5  AMZN        11   279.87      1240]\n" +
    			"[       4         5  AMZN        17   295.78      1240]\n" +
    			"[       6         5  AMZN         8   303.42      1240]\n" +
    			"[       5         5  AMZN        12   335.44      1240]\n" +
    			"[       2         6  AVGO        10   270.21      1270]\n" +
    			"[       2         3  AVGO        16   270.21      1270]\n";
    	assertEquals(exp3,got3);
    	
    	
    	String exp4 = 
    	"[ 1                Bank of Toronto  $100,000,695.54]\n" +
    	"[ 2             Bank of North York   $49,986,234.08]\n" +
    	"[ 3 Government Workers Pension Fun   $40,012,261.73]\n" +
    	"[ 4                  ABC Bank Fund   $25,012,444.22]\n" +
    	"[ 5                     John Smith       $33,785.64]\n" +
    	"[ 6                    Alice Smith      $117,059.21]\n" +
    	"[ 7                     Smith Fund      $944,678.10]\n" +
    	"[ 8  Three little pigs investments    $9,996,686.98]\n" +
    	"[                           TOTAL:  $226,103,845.50]\n";
    	
    	String got4 = exc.printBalances(false);
    	assertEquals(exp4,got4);
    	

    	System.out.println("\n\n *** T r a d e s    E x e c u t e d ***\n");
    	System.out.println(exc.printTradesLog(true));
    	System.out.println("\n\n *** O r i g i n a l   B a l a n c e s ***\n");
    	System.out.println(init_balances);
    	System.out.println("\n\n *** N e w   B a l a n c e s ***\n");
    	System.out.println(exc.printBalances(true));
    	System.out.println(exc.printFeesCollected(true));
    	
    	String got5 = exc.printFeesCollected(false);
    	String exp5 = "       $1,154.50";
    	assertEquals(exp5,got5);
    	
    	System.out.println("\n\n\n\n              **********************");
    	System.out.println("              *** Tests Complete ***");
    	System.out.println("              ********************** \n\n");
	}

}
