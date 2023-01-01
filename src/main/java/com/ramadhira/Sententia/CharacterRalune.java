package com.ramadhira.Sententia;

public class CharacterRalune extends Character {
    @Override
    public void move(int dice){
        super.move(dice);
        if(streak.size() == 2 && streak.get(streak.size()-1)==true){
            position = position + 1;
            isCanUsePassiveCharacter = false;
        }
    }
}
