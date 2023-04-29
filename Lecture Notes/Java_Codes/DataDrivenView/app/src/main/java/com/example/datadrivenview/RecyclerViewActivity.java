package com.example.datadrivenview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ArrayList coinArrayList = new ArrayList<Coin>();

        coinArrayList.add(new Coin("Bitcoin", "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579", 10000.00));
        coinArrayList.add(new Coin("Ethereum", "https://assets.coingecko.com/coins/images/279/large/ethereum.png?1595348880", 350.00));
        coinArrayList.add(new Coin("Tether", "https://assets.coingecko.com/coins/images/325/large/Tether-logo.png?1598003707", 1.00));
        coinArrayList.add(new Coin("XRP", "https://assets.coingecko.com/coins/images/44/large/xrp-symbol-white-128.png?1605778731", 0.25));
        coinArrayList.add(new Coin("Bitcoin Cash", "https://assets.coingecko.com/coins/images/780/large/bitcoin-cash-circle.png?1594689492", 250.00));
        coinArrayList.add(new Coin("Chainlink", "https://assets.coingecko.com/coins/images/877/large/chainlink-new-logo.png?1547034700", 25.00));
        coinArrayList.add(new Coin("Cardano", "https://assets.coingecko.com/coins/images/975/large/cardano.png?1547034860", 0.10));
        coinArrayList.add(new Coin("Litecoin", "https://assets.coingecko.com/coins/images/2/large/litecoin.png?1547033580", 50.00));
        coinArrayList.add(new Coin("Polkadot", "https://assets.coingecko.com/coins/images/12171/large/aJGBjJFU_400x400.jpg?1597804776", 10.00));
        coinArrayList.add(new Coin("Binance Coin", "https://assets.coingecko.com/coins/images/825/large/binance-coin-logo.png?1547034615", 25.00));
        coinArrayList.add(new Coin("Bitcoin SV", "https://assets.coingecko.com/coins/images/6799/large/BSV.png?1558947902", 150.00));
        coinArrayList.add(new Coin("USD Coin", "https://assets.coingecko.com/coins/images/6319/large/USD_Coin_icon.png?1547042389", 1.00));
        coinArrayList.add(new Coin("EOS", "https://assets.coingecko.com/coins/images/738/large/eos-eos-logo.png?1547034481", 5.00));
        coinArrayList.add(new Coin("TRON", "https://assets.coingecko.com/coins/images/1094/large/tron-logo.png?1547035066", 0.05));
        coinArrayList.add(new Coin("Monero", "https://assets.coingecko.com/coins/images/69/large/monero_logo.png?1547033729", 100.00));
        coinArrayList.add(new Coin("Stellar", "https://assets.coingecko.com/coins/images/100/large/Stellar_symbol_black_RGB.png?1552356157", 0.10));
        coinArrayList.add(new Coin("Wrapped Bitcoin", "https://assets.coingecko.com/coins/images/7598/large/wrapped_bitcoin_wbtc.png?1548822744", 10000.00));
        coinArrayList.add(new Coin("NEM", "https://assets.coingecko.com/coins/images/242/large/NEM_Logo_256x256.png?1598687029", 0.10));
        coinArrayList.add(new Coin("Cosmos", "https://assets.coingecko.com/coins/images/1481/large/cosmos_hub.png?1555657960", 10.00));
        coinArrayList.add(new Coin("Crypto.com Coin", "https://assets.coingecko.com/coins/images/7310/large/cypto.png?1547043960", 0.10));



        CoinAdapter coinAdapter = new CoinAdapter(coinArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(coinAdapter);





    }
}