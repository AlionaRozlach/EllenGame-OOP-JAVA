package sk.tuke.kpi.oop.game.items;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.ActorContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Backpack implements ActorContainer<Collectible>{

    private ArrayList<Collectible> arrayList= new ArrayList<Collectible>();
    private int capacita;
    private String name;

    public Backpack(String name, int capacity)
    {
        this.capacita = capacity;
        this.name = name;
    }

    @Override
    public @NotNull List<Collectible> getContent() {
        return arrayList;
    }

    @Override
    public int getCapacity() {
        return this.capacita;
    }

    @Override
    public int getSize() {
        return arrayList.size();
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public void add(@NotNull Collectible actor) {
        if(getSize()!=getCapacity())
        {
            arrayList.add(actor);

        }
        else
            throw new IllegalStateException();
    }

    @Override
    public void remove(@NotNull Collectible actor) {
            arrayList.remove(actor);
    }

    @Nullable
    @Override
    public Collectible peek() {
        if (getSize()>0) {
        int size = getSize();

            Collectible collectible = (Collectible) arrayList.get(size - 1);
            return collectible;
        }
        return null;
    }

    @Override
    public void shift() {

        Collections.rotate(arrayList,1);
    }

    @NotNull
    @Override
    public Iterator<Collectible> iterator() {
        return arrayList.iterator();
    }


}
