package com.plcoding.stockmarketapp.presentation.company_listings


import com.plcoding.stockmarketapp.domain.model.CompanyListing
import com.plcoding.stockmarketapp.domain.repository.StockRepository

data class CompanyListingsState(
    val companies : List<CompanyListing> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing : Boolean = false,
    val searchQuery: String = ""
)