package me.Schaffer79.Lanet;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
  
  
    public void onEnable(){
        getLogger().info("Lanet Plugini Aktif!");
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
    }
  
    public void onDisable(){
        getLogger().info("Lanet Plugini Kapatildi!");
    }
  
  
    /*
    *Variables
    */
    boolean kontrol4 = false;
    boolean kontrol3 = true;
    boolean kontrol = false;
    int i = 1;
    Block c1,c2,c3,c4,c5,c6,c7,c8,c9;
    Block d1,d2,d3,d4,d5,d6,d7,d8,d9;
    Block b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Material m1,m2,m3,m4,m5,m6,m7,m8,m9;
    HashMap<String, Integer> map = new HashMap<String, Integer>();

        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
          
            if(cmd.getName().equalsIgnoreCase("lanetle")){
              
                if(sender.hasPermission("lanetle.lanetle")){
              
                Player player = Bukkit.getPlayerExact(args[0]);
                if(args.length == 0){
                    sender.sendMessage(ChatColor.GOLD + "[Lanet]" + ChatColor.RED + "Lütfen bir oyuncu ismi girin!");
                }else if(player==null){
                    sender.sendMessage(ChatColor.GOLD + "[Lanet]" + ChatColor.RED + "Aradığınız oyuncu bulunamadı!");
                }else{
              
              
              

                String name = player.getName();
              
                if(kontrol3==true || map.get(name) == null){
                    kontrol3 = false;
                    map.put(name, 0);
                    kontrol4 = true;
                }
              
                if(map.get(name) == 1){
                    map.put(name, 0);
                    sender.sendMessage(ChatColor.GOLD + "[Lanet]" + ChatColor.RED + name + " Isimli oyuncunun lanetini kaldırdınız!!");
                }else{
                    map.put(name, 1);
                    sender.sendMessage(ChatColor.GOLD + "[Lanet]" + ChatColor.RED + name + " Isimli oyuncuyu lanetlediniz!");
                }
                return true;
                }
            }else{
                sender.sendMessage(ChatColor.GOLD + "[Lanet]" + ChatColor.RED + "Gerekli Yetkiye Sahip Degilsiniz!");
                }
            }
            return false;
        }
  
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        String name = e.getPlayer().getName();
        if(map.get(name) != 1)
        map.put(name, 3);
    }
  
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(event.getBlock() == b1 || event.getBlock() == b2 || event.getBlock() == b3 || event.getBlock() == b4 || event.getBlock() == b5 || event.getBlock() == b6 || event.getBlock() == b7 || event.getBlock() == b8 || event.getBlock() == b9){
            event.setCancelled(true);
        }
    }
      
  
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
      
        String name = event.getPlayer().getName();
      
        if(kontrol4 = true){
        if(map.get(name) != null && map.get(name) == 1){
      
        Location loc = event.getPlayer().getLocation();
        loc.setY(loc.getY() - 1);
        b1 = loc.getBlock();
        loc.setX(loc.getX() + 1);
        b2 = loc.getBlock();
        loc.setX(loc.getX() - 2);
        b3 = loc.getBlock();
        loc = event.getPlayer().getLocation();
        loc.setY(loc.getY() - 1);
        loc.setZ(loc.getZ() - 1);
        b4 = loc.getBlock();
        loc.setZ(loc.getZ() + 2);
        b5 = loc.getBlock();
        loc = event.getPlayer().getLocation();
        loc.setY(loc.getY() - 1);
        loc.setZ(loc.getZ() + 1);
        loc.setX(loc.getX() + 1);
        b6 = loc.getBlock();
        loc.setX(loc.getX() - 2);
        b7 = loc.getBlock();
        loc.setZ(loc.getZ() - 2);
        b8 = loc.getBlock();
        loc.setX(loc.getX() + 2);
        b9 = loc.getBlock();
        if(b1.getType() != Material.AIR && b1.getType() != Material.LONG_GRASS && b1.getType() != Material.DOUBLE_PLANT)
        {
            if(b1!=c1 || kontrol == false)
            {
                kontrol = true;  
                if(i==2){
                    c1.setType(m1);
                    c2.setType(m2);
                    c3.setType(m3);
                    c4.setType(m4);
                    c5.setType(m5);
                    c6.setType(m6);
                    c7.setType(m7);
                    c8.setType(m8);
                    c9.setType(m9);
                    i = 3;
                }
        if(i==1){
            c1 = b1;
            c2 = b2;
            c3 = b3;
            c4 = b4;
            c5 = b5;
            c6 = b6;
            c7 = b7;
            c8 = b8;
            c9 = b9;
            m1 = c1.getType();
            m2 = c2.getType();
            m3 = c3.getType();
            m4 = c4.getType();
            m5 = c5.getType();
            m6 = c6.getType();
            m7 = c7.getType();
            m8 = c8.getType();
            m9 = c9.getType();
            i = 2;
        }
        if(i==3){
            c1 = b1;
            c2 = b2;
            c3 = b3;
            c4 = b4;
            c5 = b5;
            c6 = b6;
            c7 = b7;
            c8 = b8;
            c9 = b9;
            m1 = c1.getType();
            m2 = c2.getType();
            m3 = c3.getType();
            m4 = c4.getType();
            m5 = c5.getType();
            m6 = c6.getType();
            m7 = c7.getType();
            m8 = c8.getType();
            m9 = c9.getType();
            i = 2;
        }  
        b1.setType(Material.GLOWSTONE);
        b2.setType(Material.REDSTONE_BLOCK);
        b3.setType(Material.REDSTONE_BLOCK);
        b4.setType(Material.REDSTONE_BLOCK);
        b5.setType(Material.REDSTONE_BLOCK);
        b6.setType(Material.NETHERRACK);
        b7.setType(Material.NETHERRACK);
        b8.setType(Material.NETHERRACK);
        b9.setType(Material.NETHERRACK);
        }else if(b1==c1){
                b1.setType(Material.GLOWSTONE);
                b2.setType(Material.REDSTONE_BLOCK);
                b3.setType(Material.REDSTONE_BLOCK);
                b4.setType(Material.REDSTONE_BLOCK);
                b5.setType(Material.REDSTONE_BLOCK);
                b6.setType(Material.NETHERRACK);
                b7.setType(Material.NETHERRACK);
                b8.setType(Material.NETHERRACK);
                b9.setType(Material.NETHERRACK);
            }
            }
        }else if(map.get(name) == 0){
            map.put(name, 3);
    }else if(map.get(name) == 3){
            b1.setType(m1);
            b2.setType(m2);
            b3.setType(m3);
            b4.setType(m4);
            b5.setType(m5);
            b6.setType(m6);
            b7.setType(m7);
            b8.setType(m8);
            b9.setType(m9);
            map.put(name,4);
            }
        }  
    }
}