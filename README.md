# YorkStockSim

## Stock Exchange Simulator

#### Overview

**YorkStockSim** is an ultra-simplified Java-based simulation of a continuous double auction CDA-based market such as a stock exchange. The exchange is based on the maintenance of a **limit order book** to which various **traders** place **orders** for buying (**bid** orders) or selling (**ask** orders) particular **securities** (stocks, bonds, etc.) in particular quantities and prices. The resulting **trades,** i.e. records of exchange of securities between traders affect the cash balances of the traders with the exchange as well as their **positions**, i.e., how much they own of each security traded in the exchange. Securities are identified by 4-letters strings called _"tickers"_.  

The limit order book is an instrument by which bids and asks are matched. It consists of two **half-book**s an ask book and a bid book. The ask book for a specific security is a list of orders to sell the security, sorted by price, ascending. As a trader who wants to buy the security at a given price, say **x**, you submit that bid order to the exchange. The exchange checks to see if any of the ask orders in the list is at **x** or lower. If not, the bid order is parked at the bid book, where all orders to buy the security are stored, sorted by price, descending. It will wait there for an ask that is **x** or lower to show up. If there are already asks that are **x** or lower in the ask book, the bidder can actually start buy those asks, until it reaches asks that are too expensive, or all the requested quantity in the bid order is satisfied. The result is a number of trades in which the trader with the bid transfers cash to the ask traders, in exchange for the corresponding quantities of the securities. 

Though a bit complex, the mechanism is the basis for the formation of prices of securities and other goods in markets of this type (called **continuous double auction - CDA** based markets). A [python-based simulation](https://github.com/davecliff/BristolStockExchange/tree/master) has been developed by the University of Bristol, and is [nicely described in the accompanying paper](https://github.com/davecliff/BristolStockExchange/blob/master/BSEguide1.2e.pdf).  

#### How to use for the assignment

This repository does not contain all source files, as some modules come pre-compiled in the form of a JAR file in `bin/lib`. In addition the Exchange.java file is missing key lines of code that prevent the application for running. 

You may want to:
- On GitHub, [fork](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/fork-a-repo) this repository to your own account.
- Work on your own copy and, once you are done, submit a link to your repository. 

Please refer to the directions on eClass for more details.
