package com.sg.recipes;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class SGRecipeProvider extends FabricRecipeProvider {

    public SGRecipeProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return "SGRecipeProvider";
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate(){
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
                //createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.GRAVEL).input(Items.COBBLESTONE).criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE)).offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.GRAVEL, Items.COBBLESTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SAND, Items.GRAVEL);
                offerSmelting(List.of(Items.DIORITE), RecipeCategory.BUILDING_BLOCKS, Items.CALCITE, 0.1f, 200, "diote");
                offerBlasting(List.of(Items.RAW_GOLD_BLOCK), RecipeCategory.BUILDING_BLOCKS, Items.GOLD_BLOCK, 1f, 900, "gold");
                offerBlasting(List.of(Items.RAW_IRON_BLOCK), RecipeCategory.BUILDING_BLOCKS, Items.IRON_BLOCK, 1f, 900, "iron");
                offerBlasting(List.of(Items.RAW_COPPER_BLOCK), RecipeCategory.BUILDING_BLOCKS, Items.COPPER_BLOCK, 1f, 900, "copper");
                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.END_STONE, 4).pattern("lw").pattern("wl").input('l', Items.COBBLESTONE).input('w', Items.SANDSTONE).group("end stone").criterion(hasItem(Items.SANDSTONE), conditionsFromItem(Items.SANDSTONE)).offerTo(exporter);
                offerSmelting(List.of(Items.BASALT), RecipeCategory.BUILDING_BLOCKS, Items.TUFF, 0.1f, 200, "basalt");
                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.RED_SAND, 2).pattern("lw").pattern("wl").input('l', Items.SAND).input('w', Items.IRON_NUGGET).group("red sand").criterion(hasItem(Items.SAND), conditionsFromItem(Items.SAND)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.DRIPSTONE_BLOCK, 4).pattern("lw").pattern("wl").input('l', Items.STONE).input('w', Items.ICE).group("dripstone").criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.MUD, 4).pattern("lw").pattern("wl").input('l', Items.DIRT).input('w', Items.ICE).group("mud").criterion(hasItem(Items.DIRT), conditionsFromItem(Items.DIRT)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.SOUL_SOIL, 4).pattern("lw").pattern("wl").input('l', Items.SOUL_SAND).input('w', Items.BONE_BLOCK).group("soul soil").criterion(hasItem(Items.SOUL_SAND), conditionsFromItem(Items.SOUL_SAND)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE, 4).pattern("lll").pattern("lll").pattern("lll").input('l', Items.STONE).group("deepslate").criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE)).offerTo(exporter);
                
            }
        };
    }
    
}
