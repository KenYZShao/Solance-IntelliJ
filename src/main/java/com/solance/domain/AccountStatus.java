package com.solance.domain;

public enum AccountStatus {
    ACTIVE,         // Normal operational state
    PENDING,        // Account being verified
    SUSPENDED,      // Temporarily blocked
    CLOSED,         // Permanently closed
    DORMANT,        // Inactive for long period
    FROZEN;         // Blocked by regulatory action
}