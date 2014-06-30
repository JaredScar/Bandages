package com.core.wolfbadger.paperbandages;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created with IntelliJ IDEA.
 * User: MayoDwarf
 * Date: 6/30/14
 * Time: 6:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main extends JavaPlugin implements Listener {
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }
    public void onDisable() {}
    @EventHandler
    public void onInteractEvent(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = e.getItem();
        if(i !=null) {
        if(i.getType() == Material.PAPER) {
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                if(!(p.getHealth() == 20)) {
                Double d = p.getHealth()+2D;
                p.setHealth(d);
                } else
                if(p.getHealth() == 19) {
                    Double d = p.getHealth()+1;
                    p.setHealth(d);
                }
                PotionEffect pe = new PotionEffect(PotionEffectType.REGENERATION, 20*4, 1, true);
                p.addPotionEffect(pe);
                p.getInventory().removeItem(new ItemStack(p.getItemInHand().getType(), 1, p.getItemInHand().getDurability()));
                }
            }
        }
    }
    @EventHandler
    public void onInteractEntityEvent(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        if(e.getRightClicked() instanceof Player && p.getItemInHand() !=null) {
            if(p.getItemInHand().getType() == Material.PAPER) {
            Player pl = (Player) e.getRightClicked();
            if(!(pl.getHealth() == 20)) {
                Double d = pl.getHealth()+2D;
                pl.setHealth(d);
            } else
            if(pl.getHealth() == 19) {
                Double d = pl.getHealth()+1;
                pl.setHealth(d);
            }
            PotionEffect pe = new PotionEffect(PotionEffectType.REGENERATION, 20*4, 1, true);
            pl.addPotionEffect(pe);
            p.getInventory().removeItem(new ItemStack(p.getItemInHand().getType(), 1, p.getItemInHand().getDurability()));
            }
        }
    }
}
