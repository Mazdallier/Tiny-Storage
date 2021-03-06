package com.timthebrick.tinystorage.client.gui.widgets.settings;

import java.util.EnumSet;

import javax.annotation.Nonnull;

public enum ButtonSettings {
	
	AUTOMATED_SIDE_ACCESS(EnumSet.allOf(AccessMode.class));
	
	private final EnumSet<? extends Enum<?>> values;

	ButtonSettings( @Nonnull EnumSet<? extends Enum<?>> possibleOptions )
	{
		if ( possibleOptions.isEmpty() )
		{
			throw new IllegalArgumentException( "Tried to instantiate an empty setting." );
		}

		this.values = possibleOptions;
	}

	public EnumSet<? extends Enum<?>> getPossibleValues()
	{
		return this.values;
	}
}
