package poker;

import java.io.*;

/**
 * Created by tri___ton on 24.01.16.
 */


    public  class Human implements Serializable {
        private String name;
        private int oppHands;
        private double oppWinnings;
        private double oppOverBet;

        private double oppVpp;
        private double oppPfr;
        private double opp3bet;
        private double opp4bet;
        private double oppFold3bet;

        private double oppContbet;
        private double oppFoldcontbet;
        private double oppCheckraise;

        private double oppBetRiver;
        private double oppblockBetRiver;
        private double oppOverBettRiver;


        private double oppWentShowdown;
        private double oppWinshodown;
        private double oppWinriveraction;
        private double oppWinBlockBetRiver;
        private double oppWinOverBetRiver;

        public Human() {

        }


        public Human(String name) {
            this.name = name;
            this.oppHands = 0;
            this.oppWinnings = 0;
            this.oppOverBet = 0;
            this.oppVpp = 0;
            this.oppPfr = 0;
            this.opp3bet = 0;
            this.opp4bet = 0;
            this.oppFold3bet = 0;
            this.oppContbet = 0;
            this.oppFoldcontbet = 0;
            this.oppCheckraise = 0;
            this.oppBetRiver = 0;
            this.oppblockBetRiver = 0;
            this.oppOverBettRiver = 0;
            this.oppWentShowdown = 0;
            this.oppWinshodown = 0;
            this.oppWinriveraction = 0;
            this.oppWinBlockBetRiver = 0;
            this.oppWinOverBetRiver = 0;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOppHands() {
        return oppHands;
    }

    public void setOppHands(int oppHands) {
        this.oppHands = oppHands;
    }

    public double getOppWinnings() {
        return oppWinnings;
    }

    public void setOppWinnings(double oppWinnings) {
        this.oppWinnings = oppWinnings;
    }

    public double getOppOverBet() {
        return oppOverBet;
    }

    public void setOppOverBet(double oppOverBet) {
        this.oppOverBet = oppOverBet;
    }

    public double getOppVpp() {
        return oppVpp;
    }

    public void setOppVpp(double oppVpp) {
        this.oppVpp = oppVpp;
    }

    public double getOppPfr() {
        return oppPfr;
    }

    public void setOppPfr(double oppPfr) {
        this.oppPfr = oppPfr;
    }

    public double getOpp3bet() {
        return opp3bet;
    }

    public void setOpp3bet(double opp3bet) {
        this.opp3bet = opp3bet;
    }

    public double getOpp4bet() {
        return opp4bet;
    }

    public void setOpp4bet(double opp4bet) {
        this.opp4bet = opp4bet;
    }

    public double getOppFold3bet() {
        return oppFold3bet;
    }

    public void setOppFold3bet(double oppFold3bet) {
        this.oppFold3bet = oppFold3bet;
    }

    public double getOppContbet() {
        return oppContbet;
    }

    public void setOppContbet(double oppContbet) {
        this.oppContbet = oppContbet;
    }

    public double getOppFoldcontbet() {
        return oppFoldcontbet;
    }

    public void setOppFoldcontbet(double oppFoldcontbet) {
        this.oppFoldcontbet = oppFoldcontbet;
    }

    public double getOppCheckraise() {
        return oppCheckraise;
    }

    public void setOppCheckraise(double oppCheckraise) {
        this.oppCheckraise = oppCheckraise;
    }

    public double getOppBetRiver() {
        return oppBetRiver;
    }

    public void setOppBetRiver(double oppBetRiver) {
        this.oppBetRiver = oppBetRiver;
    }

    public double getOppblockBetRiver() {
        return oppblockBetRiver;
    }

    public void setOppblockBetRiver(double oppblockBetRiver) {
        this.oppblockBetRiver = oppblockBetRiver;
    }

    public double getOppOverBettRiver() {
        return oppOverBettRiver;
    }

    public void setOppOverBettRiver(double oppOverBettRiver) {
        this.oppOverBettRiver = oppOverBettRiver;
    }

    public double getOppWentShowdown() {
        return oppWentShowdown;
    }

    public void setOppWentShowdown(double oppWentShowdown) {
        this.oppWentShowdown = oppWentShowdown;
    }

    public double getOppWinshodown() {
        return oppWinshodown;
    }

    public void setOppWinshodown(double oppWinshodown) {
        this.oppWinshodown = oppWinshodown;
    }

    public double getOppWinriveraction() {
        return oppWinriveraction;
    }

    public void setOppWinriveraction(double oppWinriveraction) {
        this.oppWinriveraction = oppWinriveraction;
    }

    public double getOppWinBlockBetRiver() {
        return oppWinBlockBetRiver;
    }

    public void setOppWinBlockBetRiver(double oppWinBlockBetRiver) {
        this.oppWinBlockBetRiver = oppWinBlockBetRiver;
    }

    public double getOppWinOverBetRiver() {
        return oppWinOverBetRiver;
    }

    public void setOppWinOverBetRiver(double oppWinOverBetRiver) {
        this.oppWinOverBetRiver = oppWinOverBetRiver;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", oppHands=" + oppHands +
                ", oppWinnings=" + oppWinnings +
                ", oppOverBet=" + oppOverBet +
                ", oppVpp=" + oppVpp +
                ", oppPfr=" + oppPfr +
                ", opp3bet=" + opp3bet +
                ", opp4bet=" + opp4bet +
                ", oppFold3bet=" + oppFold3bet +
                ", oppContbet=" + oppContbet +
                ", oppFoldcontbet=" + oppFoldcontbet +
                ", oppCheckraise=" + oppCheckraise +
                ", oppBetRiver=" + oppBetRiver +
                ", oppblockBetRiver=" + oppblockBetRiver +
                ", oppOverBettRiver=" + oppOverBettRiver +
                ", oppWentShowdown=" + oppWentShowdown +
                ", oppWinshodown=" + oppWinshodown +
                ", oppWinriveraction=" + oppWinriveraction +
                ", oppWinBlockBetRiver=" + oppWinBlockBetRiver +
                ", oppWinOverBetRiver=" + oppWinOverBetRiver +
                '}';
    }
}

