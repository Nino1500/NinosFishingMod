package me.nino.anglersdream.item.custom.bags;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IronBagItem extends Item {

    public IronBagItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> components, TooltipFlag flag) {
        components.add(Component.literal("Rightclick to open").withStyle(ChatFormatting.AQUA));
        components.add(Component.literal("Shift for more Information").withStyle(ChatFormatting.YELLOW));
        if (Screen.hasShiftDown()) {
            components.add(Component.literal("-> Iron, more Iron and much more Iron").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, tooltipContext, components, flag);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!level.isClientSide){
            itemstack.shrink(1);
            getLoot(player);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

    public void getLoot(Player player) {
        ArrayList<ItemStack> loot = generateLoot();

        if (loot.isEmpty()){
            return;
        }

        Random random = new Random();

        ItemStack randomItem = loot.get(random.nextInt(loot.size()));
        ItemEntity item = new ItemEntity(player.level(), player.getX(), player.getY(), player.getZ(), randomItem);

        player.level().addFreshEntity(item);
    }

    public ArrayList<ItemStack> generateLoot() {
        ArrayList<ItemStack> loot = new ArrayList<>();
        Random random = new Random();
        loot.add(new ItemStack(Items.IRON_INGOT, random.nextInt(2)+1));
        loot.add(new ItemStack(Items.IRON_INGOT, random.nextInt(3)+1));
        loot.add(new ItemStack(Items.IRON_INGOT, random.nextInt(4)+1));
        loot.add(new ItemStack(Items.IRON_INGOT, random.nextInt(5)+1));
        loot.add(new ItemStack(Items.IRON_INGOT, random.nextInt(6)+1));
        loot.add(new ItemStack(Items.IRON_INGOT, random.nextInt(7)+1));
        loot.add(new ItemStack(Items.IRON_INGOT, random.nextInt(8)+1));
        loot.add(new ItemStack(Items.IRON_INGOT, random.nextInt(9)+1));
        loot.add(new ItemStack(Items.RAW_IRON, random.nextInt(2)+1));
        loot.add(new ItemStack(Items.RAW_IRON, random.nextInt(3)+1));
        loot.add(new ItemStack(Items.RAW_IRON, random.nextInt(4)+1));
        loot.add(new ItemStack(Items.RAW_IRON, random.nextInt(5)+1));
        loot.add(new ItemStack(Items.RAW_IRON, random.nextInt(6)+1));
        loot.add(new ItemStack(Items.RAW_IRON, random.nextInt(7)+1));
        loot.add(new ItemStack(Items.RAW_IRON, random.nextInt(8)+1));
        loot.add(new ItemStack(Items.RAW_IRON, random.nextInt(9)+1));
        loot.add(new ItemStack(Items.IRON_BLOCK, 1));
        loot.add(new ItemStack(Items.RAW_IRON_BLOCK, random.nextInt(2)+1));

        return loot;
    }

}
